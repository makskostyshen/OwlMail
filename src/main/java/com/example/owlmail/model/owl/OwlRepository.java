package com.example.owlmail.model.owl;

import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import com.example.owlmail.model.owl.components.OwlId;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface OwlRepository extends CrudRepository<Owl, OwlId> {

  Optional<Owl> findByNameAndBreedAndColor(String name, OwlBreed breed, OwlColor color);
}
