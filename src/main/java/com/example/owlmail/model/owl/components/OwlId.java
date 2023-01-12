package com.example.owlmail.model.owl.components;

import java.io.Serializable;
import lombok.Getter;

@Getter
public class OwlId implements Serializable {
  private String name;
  private OwlBreed breed;
  private OwlColor color;
}
