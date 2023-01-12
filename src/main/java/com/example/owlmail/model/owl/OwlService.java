package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import com.example.owlmail.model.owl.components.OwlId;
import org.springframework.stereotype.Service;

@Service
public class OwlService {

  private final OwlRepository owlRepository;

  public OwlService(OwlRepository owlRepository) {
    this.owlRepository = owlRepository;
  }

  public Owl findOwlByNameAndBreedAndColor(OwlId owlId){
    String name = owlId.getName();
    OwlBreed breed = owlId.getBreed();
    OwlColor color = owlId.getColor();

    Owl owl = owlRepository
        .findByNameAndBreedAndColor(name, breed, color)
        .orElseThrow(OwlNotFoundException::new);

    System.out.println(owl);
    return owl;
  }
}
