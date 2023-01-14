package com.example.owlmail.initialization;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterRepository;
import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardRepository;
import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlRepository;
import com.example.owlmail.model.owl.components.OwlBreed;
import com.example.owlmail.model.owl.components.OwlColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for initial loading of data.
 */
@Configuration
public class LoadData {

  private final WizardRepository wizardRepository;
  private final OwlRepository owlRepository;
  private final LetterRepository letterRepository;

  @Autowired
  public LoadData(WizardRepository wizardRepository, OwlRepository owlRepository,
      LetterRepository letterRepository) {
    this.wizardRepository = wizardRepository;
    this.owlRepository = owlRepository;
    this.letterRepository = letterRepository;
  }

  /**
   * Load initial data into database.
   */
  @Bean
  public CommandLineRunner loadDatabase() {
    Wizard wizardKostyshen = new Wizard(null, "Maks", "Kostyshen");
    Wizard wizardSara = new Wizard(null, "Art", "Sara");

    Owl owlKostyshen = new Owl(null, "Gedviga", OwlBreed.BASIC, OwlColor.GRAY, wizardKostyshen);
    Letter letterToSaraFromKostyshen =
        new Letter(null, "Attention!!", "I want to kiss you", wizardSara,
                                      owlKostyshen);
    return args -> {
      wizardRepository.save(wizardKostyshen);
      wizardRepository.save(wizardSara);

      owlRepository.save(owlKostyshen);
      letterRepository.save(letterToSaraFromKostyshen);
    };
  }
}
