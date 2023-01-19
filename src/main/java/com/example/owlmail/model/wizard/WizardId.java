package com.example.owlmail.model.wizard;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity Id class.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WizardId implements Serializable {
  private String firstName;
  private String familyName;
}
