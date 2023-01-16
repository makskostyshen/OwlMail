package com.example.owlmail.model.wizard;

import com.example.owlmail.model.wizard.parts.WizardId;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository class.
 */
public interface WizardRepository extends CrudRepository<Wizard, WizardId> {

  Optional<Wizard> findByFirstNameAndFamilyName(String firstName, String familyName);
}
