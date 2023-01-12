package com.example.owlmail.controllers;

import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
public class MagicianController {

  private final WizardService wizardService;

  @Autowired
  public MagicianController(WizardService wizardService) {
    this.wizardService = wizardService;
  }

  @GetMapping(value = "/magician/{id}")
  public Wizard getMagician(@PathVariable Long id) {
    return wizardService.findById(id);
  }

}
