package com.example.owlmail.model.owl;

import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import com.example.owlmail.model.owl.components.OwlId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@IdClass(OwlId.class)
public class Owl {

  @Id
  private String name;
  @Id
  @Enumerated(EnumType.STRING)
  private OwlBreed breed;
  @Id
  @Enumerated(EnumType.STRING)
  private OwlColor color;

  @ManyToOne
  @JoinColumn(name = "magician_id")
  private Wizard wizard;

}
