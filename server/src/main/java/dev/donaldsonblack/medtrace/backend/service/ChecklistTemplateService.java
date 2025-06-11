package dev.donaldsonblack.medtrace.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.donaldsonblack.medtrace.backend.model.ChecklistTemplate;
import dev.donaldsonblack.medtrace.backend.model.EquipmentModel;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistTemplateService {

    @Autowired
    private DataSource dataSource;

    public List<ChecklistTemplate> getAllRecords() {
        List<ChecklistTemplate> records = new ArrayList<>();
        String sql = "SELECT * FROM checklist_templates";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChecklistTemplate record = new ChecklistTemplate();
                record.setEquipId(rs.getInt("equip_id"));
                record.setDescription(rs.getString("description"));
                record.setTemplateJsonString(rs.getString("template_json"));
                record.setCreatedAt(rs.getTimestamp("created_at"));

                records.add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}