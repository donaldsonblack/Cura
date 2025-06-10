package dev.donaldsonblack.medtrace.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dev.donaldsonblack.medtrace.backend.model.EquipmentModel;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private DataSource dataSource;

    public List<EquipmentModel> getAllRecords() {
        List<EquipmentModel> records = new ArrayList<>();
        String sql = "SELECT * FROM medtracedev";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EquipmentModel record = new EquipmentModel();
                record.setId(rs.getInt("equip_ID"));
                record.setName(rs.getString("equip_name"));
                records.add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}

// public List<EquipmentService> getAllRecords() {
// List<MedtracedevRecord> records = new ArrayList<>();
// String sql = "SELECT * FROM medtracedev";

// try (Connection conn = dataSource.getConnection();
// PreparedStatement stmt = conn.prepareStatement(sql);
// ResultSet rs = stmt.executeQuery()) {

// while (rs.next()) {
// MedtracedevRecord record = new MedtracedevRecord();
// record.setYear(rs.getInt("year"));
// record.setName(rs.getString("name"));
// records.add(record);
// }

// } catch (Exception e) {
// e.printStackTrace();
// }

// return records;
// }
