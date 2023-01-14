package com.example.owlmail.model.wizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class.
 */
@Service
public class WizardService {

  private final WizardRepository wizardRepository;

  @Autowired
  public WizardService(WizardRepository wizardRepository) {
    this.wizardRepository = wizardRepository;
  }

  public Wizard findById(Long id) {
    return wizardRepository.findMagicianById(id).orElseThrow(WizardNotFoundException::new);
  }
}
