package dev.donaldsonblack.medtrace.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import dev.donaldsonblack.medtrace.backend.model.MedtracedevRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedtracedevService {

    @Autowired
    private DataSource dataSource;

    public List<MedtracedevRecord> getAllRecords() {
        List<MedtracedevRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM medtracedev";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MedtracedevRecord record = new MedtracedevRecord();
                record.setYear(rs.getInt("year"));
                record.setName(rs.getString("name"));
                records.add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}
