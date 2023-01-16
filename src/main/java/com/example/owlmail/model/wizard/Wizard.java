package com.example.owlmail.model.wizard;


import com.example.owlmail.model.wizard.parts.WizardId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Magician entity.
 */
@Entity
@IdClass(WizardId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wizard {
  @Id
  private String firstName;
  @Id
  private String familyName;
  private LocalDate registrationDate;
}
