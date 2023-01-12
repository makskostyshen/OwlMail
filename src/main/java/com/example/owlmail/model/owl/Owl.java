package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import com.example.owlmail.model.owl.components.OwlId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(OwlId.class)
public class Owl {

  @Id
  private String name;
  @Id
  private OwlBreed breed;
  @Id
  private OwlColor color;

}
