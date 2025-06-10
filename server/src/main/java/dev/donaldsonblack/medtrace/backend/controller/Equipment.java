package dev.donaldsonblack.medtrace.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donaldsonblack.medtrace.backend.model.EquipmentModel;
import dev.donaldsonblack.medtrace.backend.service.EquipmentService;

@RestController
@RequestMapping("/api/equipment")
public class Equipment {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/all")
    public List<EquipmentModel> getAllRecords() {
        return equipmentService.getAllRecords();
    }
}
