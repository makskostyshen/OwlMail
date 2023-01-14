package com.example.owlmail.model.owl;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface OwlRepository extends CrudRepository<Owl, Long> {

  Optional<Owl> findById(Long id);
}
