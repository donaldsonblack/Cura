package dev.donaldsonblack.cura.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import dev.donaldsonblack.cura.model.Checklist;
import dev.donaldsonblack.cura.service.ChecklistService;

@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

  @Autowired
  private ChecklistService checkListService;

  @GetMapping()
  public List<Checklist> list() {
    return checkListService.getAllChecklists();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Checklist create(@RequestBody Checklist req) {
    return checkListService.insert(req);
  }

  @GetMapping("/{id}")
  public Checklist getById(@PathVariable UUID id) {
    return checkListService.getById(id);
  }

}
