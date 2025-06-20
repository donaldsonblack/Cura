package dev.donaldsonblack.cura.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.donaldsonblack.cura.model.Checklist;

@Service
public class ChecklistService {

  private final JdbcTemplate jdbcTemplate;

  public ChecklistService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Autowired
  private DataSource dataSource;

  public List<Checklist> getAllChecklists() {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Checklist> cl = new ArrayList<>();
    String sql = "SELECT * FROM checklists";

    try (Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        Checklist c = new Checklist();

        c.setUUID((UUID) rs.getObject("ID"));
        c.setType(rs.getString("type"));
        c.setDepartment(rs.getString("department"));
        c.setAuthor(rs.getString("author"));
        c.setCreated(new Date(rs.getTimestamp("created").getTime()));
        c.setQuestions(objectMapper.readTree(rs.getString("questions")));

        cl.add(c);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return cl;
  }

  public Checklist getById(UUID id) {
    ObjectMapper objectMapper = new ObjectMapper();
    String sql = "SELECT * FROM checklists where id='" + id + "'";
    ResultSet rs;
    Checklist c = new Checklist();

    try {
      rs = query(sql);

      rs.next();

      c.setUUID((UUID) rs.getObject("ID"));
      c.setType(rs.getString("type"));
      c.setDepartment(rs.getString("department"));
      c.setAuthor(rs.getString("author"));
      c.setCreated(new Date(rs.getTimestamp("created").getTime()));
      c.setQuestions(objectMapper.readTree(rs.getString("questions")));

      return c;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public Checklist insert(Checklist c) {
    // Note: adjust "checklists" to your actual table name if it's singular
    String sql = """
        INSERT INTO checklists
          (type, department, author, created, questions)
        VALUES
          (?,      ?,          ?,      ?,        ?::jsonb)
        """;

    // Execute the insert
    jdbcTemplate.update(
        sql,
        c.getType(),
        c.getDepartment(),
        c.getAuthor(),
        new Timestamp(c.getCreated().getTime()),
        // store the JSONObject’s raw JSON text
        c.getQuestions().toString());

    // Return the same object (now “persisted”)
    return c;
  }

  public ResultSet query(String sql) throws SQLException {
    Connection conn = dataSource.getConnection();
    PreparedStatement stmt = conn.prepareStatement(sql);
    return stmt.executeQuery();
  }
}
