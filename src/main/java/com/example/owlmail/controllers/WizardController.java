package com.example.owlmail.controllers;

import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardService;
import com.example.owlmail.model.wizard.parts.WizardId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
@RequestMapping(value = "/wizard")
public class WizardController {

  private final WizardService wizardService;

  @Autowired
  public WizardController(WizardService wizardService) {
    this.wizardService = wizardService;
  }

  @GetMapping()
  public Wizard getMagician(@RequestBody WizardId wizardId) {

    return wizardService.findByWizardId(wizardId);
  }

}
