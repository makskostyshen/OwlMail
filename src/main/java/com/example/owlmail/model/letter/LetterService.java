package com.example.owlmail.model.letter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class.
 */
@Service
public class LetterService {
  private final LetterRepository letterRepository;

  @Autowired
  public LetterService(LetterRepository letterRepository) {
    this.letterRepository = letterRepository;
  }

  public Letter findById(Long id) {
    return letterRepository.findById(id).orElseThrow(LetterNotFoundException::new);
  }
}
