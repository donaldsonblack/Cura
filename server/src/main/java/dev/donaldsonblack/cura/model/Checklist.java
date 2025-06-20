package dev.donaldsonblack.cura.model;

import java.util.Date;
import java.util.UUID;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

public class Checklist {
  private UUID id; // Unique ID per checklist, generated
  private String type; // What is the type of equipment which the checklist is checking, e.g. trolley
  private String department; // Department Name, e.g. Pediatrics

  private String author; // Who created the checklist
  private Date created; // When was the checklist Created

  private JsonNode questions; // Checklist questions stored in json

  public UUID getId() {
    return this.id;
  }

  public void setUUID(UUID id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getCreated() {
    return this.created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public JsonNode getQuestions() {
    return this.questions;
  }

  public void setQuestions(JsonNode questions) {
    this.questions = questions;
  }
}
