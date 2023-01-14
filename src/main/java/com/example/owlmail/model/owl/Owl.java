package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import com.example.owlmail.model.wizard.Wizard;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Owl entity.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Owl {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Enumerated(EnumType.STRING)
  private OwlBreed breed;

  @Enumerated(EnumType.STRING)
  private OwlColor color;

  @ManyToOne
  @JoinColumn(name = "magician_id")
  private Wizard wizard;

}
