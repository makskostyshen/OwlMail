package com.example.owlmail.model.magician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Magician Service class.
 */
@Service
public class MagicianService {

  private final MagicianRepository magicianRepository;

  @Autowired
  public MagicianService(MagicianRepository magicianRepository) {
    this.magicianRepository = magicianRepository;
  }

  public Magician findById(Long id) {
    return magicianRepository.findMagicianById(id).orElseThrow(MagicianNotFoundException::new);
  }
}
