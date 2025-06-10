package dev.donaldsonblack.medtrace.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.donaldsonblack.medtrace.backend.model.MedtracedevRecord;
import dev.donaldsonblack.medtrace.backend.service.MedtracedevService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/medtracedev")
public class MedtracedevController {
  @Autowired
  private MedtracedevService medtracedevService;

  @GetMapping("/all")
  public List<MedtracedevRecord> getAllRecords() {
    return medtracedevService.getAllRecords();
  }
}
