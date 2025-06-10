package dev.donaldsonblack.medtrace.backend.model;

public class EquipmentModel {
  private int equipmentId;
  private String equipmentName;

  public String getName() {
    return this.equipmentName;
  }

  public int getId() {
    return this.equipmentId;
  }

  public void setName(String name) {
    this.equipmentName = name;
  }

  public void setId(int id) {
    this.equipmentId = id;
  }
}
