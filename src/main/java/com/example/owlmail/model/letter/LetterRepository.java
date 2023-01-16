package com.example.owlmail.model.letter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository class.
 */
public interface LetterRepository extends CrudRepository<Letter, Long> {

  Optional<Letter> findById(Long id);
}
