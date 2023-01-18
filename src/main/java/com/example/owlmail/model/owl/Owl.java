package com.example.owlmail.model.owl;

import com.example.owlmail.model.wizard.Wizard;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owl {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @Enumerated(EnumType.STRING)
  private OwlBreed breed;

  private LocalDate ownershipStartDate;
  private LocalDate dateOfBirth;

  @ManyToOne
  private Wizard wizard;
}
