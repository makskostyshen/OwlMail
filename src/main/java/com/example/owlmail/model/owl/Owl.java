package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.parts.OwlBreed;
import com.example.owlmail.model.owl.parts.OwlColor;
import com.example.owlmail.model.owl.parts.OwlId;
import com.example.owlmail.model.wizard.Wizard;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Owl entity.
 */



@Entity
@IdClass(OwlId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owl {

  @Id
  private String name;

  @Id
  @Enumerated(EnumType.STRING)
  private OwlBreed breed;

  @Id
  @Enumerated(EnumType.STRING)
  private OwlColor color;

  private LocalDate ownershipStartDate;
  private LocalDate dateOfBirth;

  @ManyToOne
  private Wizard wizard;
}
