package com.example.owlmail.model.owl;

import org.springframework.stereotype.Service;

@Service
public class OwlService {
  private final OwlRepository owlRepository;

  public OwlService(OwlRepository owlRepository) {
    this.owlRepository = owlRepository;
  }

  public Owl findById(Long id){
    return owlRepository
        .findById(id)
        .orElseThrow(OwlNotFoundException::new);
  }
}
