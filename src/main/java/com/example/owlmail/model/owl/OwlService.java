package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.parts.OwlBreed;
import com.example.owlmail.model.owl.parts.OwlColor;
import com.example.owlmail.model.owl.parts.OwlId;
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
   * Find owl by OwlId in repository.
   *
   * @return Owl if existing
   * @throws OwlNotFoundException if not existing.
   */
  public Owl findByOwlId(OwlId owlId) {
    String name = owlId.getName();
    OwlBreed breed = owlId.getBreed();
    OwlColor color = owlId.getColor();

    return owlRepository
        .findByNameAndBreedAndColor(name, breed, color)
        .orElseThrow(OwlNotFoundException::new);
  }
}
