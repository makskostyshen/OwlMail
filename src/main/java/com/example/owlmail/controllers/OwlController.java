package com.example.owlmail.controllers;

import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlService;
import com.example.owlmail.model.owl.parts.OwlId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
@RequestMapping(value = "/owl")
public class OwlController {

  private final OwlService owlService;

  @Autowired
  public OwlController(OwlService owlService) {
    this.owlService = owlService;
  }

  @GetMapping()
  public Owl getOwl(@RequestBody OwlId owlId) {
    return owlService.findByOwlId(owlId);
  }
}
