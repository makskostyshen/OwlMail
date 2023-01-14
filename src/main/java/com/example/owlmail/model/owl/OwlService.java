package com.example.owlmail.model.owl;

import org.springframework.stereotype.Service;

/**
 * Service class.
 */
@Service
public class OwlService {
  private final OwlRepository owlRepository;

  public OwlService(OwlRepository owlRepository) {
    this.owlRepository = owlRepository;
  }

  /**
   * Find owl by id in repository.
   *
   * @return Owl if existing
   * @throws OwlNotFoundException if not existing.
   */
  public Owl findById(Long id) {
    return owlRepository
        .findById(id)
        .orElseThrow(OwlNotFoundException::new);
  }
}
