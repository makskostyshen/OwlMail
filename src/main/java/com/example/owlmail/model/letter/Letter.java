package com.example.owlmail.model.letter;

import com.example.owlmail.model.magician.Magician;
import com.example.owlmail.model.owl.Owl;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Letter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String header;
  private String message;

  @ManyToOne
  private Magician addressee;

  @ManyToOne
  private Owl owl;

}
