package com.example.owlmail.model.wizard;

import com.example.owlmail.model.wizard.parts.WizardId;
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

  /**
   * Find wizard by WizardId in repository.
   *
   * @return Wizard if existing
   * @throws WizardNotFoundException if not existing.
   */
  public Wizard findByWizardId(WizardId wizardId) {
    String firstName = wizardId.getFirstName();
    String familyName = wizardId.getFamilyName();

    return wizardRepository
        .findByFirstNameAndFamilyName(firstName, familyName)
        .orElseThrow(WizardNotFoundException::new);
  }
}
