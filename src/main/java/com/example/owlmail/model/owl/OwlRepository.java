package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.parts.OwlBreed;
import com.example.owlmail.model.owl.parts.OwlColor;
import com.example.owlmail.model.owl.parts.OwlId;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository class.
 */
public interface OwlRepository extends CrudRepository<Owl, OwlId> {

  Optional<Owl> findByNameAndBreedAndColor(String name, OwlBreed breed, OwlColor color);
}
