package com.example.owlmail.model.owl.parts;

import java.io.Serializable;
import lombok.Getter;

/**
 * Entity Id class.
 */
@Getter
public class OwlId implements Serializable {
  private String name;
  private OwlBreed breed;
  private OwlColor color;
}
