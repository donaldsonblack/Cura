package dev.donaldsonblack.medtrace.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donaldsonblack.medtrace.backend.model.MedtracedevRecord;
import dev.donaldsonblack.medtrace.backend.service.EquipmentService;
import dev.donaldsonblack.medtrace.backend.service.MedtracedevService;

@RestController
@RequestMapping("/api/equipment")
public class Equipment {
    @Autowired
    private EquipmentService equipmentService;

    // @GetMapping("/all")
    // public List<MedtracedevRecord> getAllRecords() {
    // return equipmentService.getAllRecords();
    // }
}
