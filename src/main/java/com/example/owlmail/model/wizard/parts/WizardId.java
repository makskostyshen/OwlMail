package com.example.owlmail.model.wizard.parts;

import java.io.Serializable;
import lombok.Getter;

/**
 * Entity Id class.
 */
@Getter
public class WizardId implements Serializable {
  private String firstName;
  private String familyName;
}
