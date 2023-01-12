package com.example.owlmail.controllers;

import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlService;
import com.example.owlmail.model.owl.components.OwlId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwlController {

  private final OwlService owlService;

  @Autowired
  public OwlController(OwlService owlService) {
    this.owlService = owlService;
  }

  @GetMapping(value = "/owl")
  public Owl getOwl(@RequestBody OwlId owlId){
    Owl owl = owlService.findOwlByNameAndBreedAndColor(owlId);
    System.out.println(owl);
    return owl;
  }
}
