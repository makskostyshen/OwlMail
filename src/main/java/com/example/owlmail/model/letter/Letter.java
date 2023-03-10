package com.example.owlmail.model.letter;

import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.wizard.Wizard;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Letter entity.
 */
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
  private String body;
  private LocalDateTime dateTime;

  @ManyToOne
  private Wizard sender;

  @ManyToOne
  private Owl owl;

  @ManyToOne
  private Wizard receiver;
}
