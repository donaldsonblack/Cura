package dev.donaldsonblack.medtrace.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donaldsonblack.medtrace.backend.model.EquipmentModel;
import dev.donaldsonblack.medtrace.backend.service.EquipmentService;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/all")
    public List<EquipmentModel> getAllRecords() {
        return equipmentService.getAllRecords();
    }

    @GetMapping("/id/{id}")
    public EquipmentModel getRecordById(@PathVariable int id) {
        return equipmentService.getRecordById(id);
    }

    @GetMapping("/name/{name}")
    public EquipmentModel getRecordByName(@PathVariable String name) {
        return equipmentService.getRecordByName(name);
    }
}
