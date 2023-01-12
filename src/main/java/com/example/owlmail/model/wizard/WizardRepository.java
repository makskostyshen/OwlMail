package com.example.owlmail.model.wizard;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Magician Repository class.
 */
public interface WizardRepository extends CrudRepository<Wizard, Long> {

  Optional<Wizard> findMagicianById(Long id);
}
