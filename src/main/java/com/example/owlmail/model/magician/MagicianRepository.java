package com.example.owlmail.model.magician;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Magician Repository class.
 */
public interface MagicianRepository extends CrudRepository<Magician, Long> {

  Optional<Magician> findMagicianById(Long id);
}
