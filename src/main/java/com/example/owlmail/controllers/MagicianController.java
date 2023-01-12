package com.example.owlmail.controllers;

import com.example.owlmail.model.magician.Magician;
import com.example.owlmail.model.magician.MagicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
public class MagicianController {

  private final MagicianService magicianService;

  @Autowired
  public MagicianController(MagicianService magicianService) {
    this.magicianService = magicianService;
  }

  @GetMapping(value = "/magician/{id}")
  public Magician getMagician(@PathVariable Long id) {
    return magicianService.findById(id);
  }

}
