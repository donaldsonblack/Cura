package dev.donaldsonblack.medtrace.backend.model;

import java.sql.Timestamp;
import org.json.JSONObject;

public class ChecklistTemplate {
    private int equip_id;
    private String description;
    private JSONObject template_json;
    private String template_json_String;
    private Timestamp created_at;

    public int getEquipId() {
        return equip_id;
    }

    public void setEquipId(int equip_id) {
        this.equip_id = equip_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject getTemplateJson() {
        return template_json;
    }

    public void setTemplateJson(JSONObject template_json) {
        this.template_json = template_json;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setTemplateJsonString(String template_json_String) {
        this.template_json_String = template_json_String;
    }

    public String getTemplateJsonString() {
        return template_json_String;
    }
}
