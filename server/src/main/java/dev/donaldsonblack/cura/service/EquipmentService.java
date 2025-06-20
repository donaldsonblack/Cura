package dev.donaldsonblack.cura.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.donaldsonblack.cura.backend.model.EquipmentModel;

@Service
public class EquipmentService {

    @Autowired
    private DataSource dataSource;

    public List<EquipmentModel> getAllRecords() {
        List<EquipmentModel> records = new ArrayList<>();
        String sql = "SELECT * FROM equip";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EquipmentModel record = new EquipmentModel();
                System.out.println(rs.toString());
                record.setId(rs.getInt("equip_id"));
                record.setName(rs.getString("equip_name"));
                records.add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public EquipmentModel getRecordById(int id) {
        EquipmentModel record = null;
        String sql = "SELECT * FROM equip WHERE equip_id = ?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    record = new EquipmentModel();
                    record.setId(rs.getInt("equip_id"));
                    record.setName(rs.getString("equip_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return record;
    }

    public EquipmentModel getRecordByName(String name) {
        EquipmentModel record = null;
        String sql = "SELECT * FROM equip WHERE equip_name = ?";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    record = new EquipmentModel();
                    record.setId(rs.getInt("equip_id"));
                    record.setName(rs.getString("equip_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return record;
    }

    public void addRecord(EquipmentModel record) {
        String sql = "INSERT INTO equip (equip_name) VALUES (?)";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, record.getName());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
