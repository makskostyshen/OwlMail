package com.example.owlmail.initialization;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterRepository;
import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlRepository;
import com.example.owlmail.model.owl.parts.OwlBreed;
import com.example.owlmail.model.owl.parts.OwlColor;
import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

  /**
   * Constructor.
   */
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
    Wizard wizardKostyshen = new Wizard("Maks", "Kostyshen",
        LocalDate.of(2022, 12, 29));
    Wizard wizardSara = new Wizard("Art", "Sara",
        LocalDate.of(2023, 1, 10));

    Owl owlKostyshen =
        new Owl("Gedviga", OwlBreed.BASIC, OwlColor.GRAY,
            LocalDate.of(2022, 12, 31),
            LocalDate.of(2017, 4, 6),
            wizardKostyshen);

    Letter letterToSaraFromKostyshen =
        new Letter(null, "Attention!!", "I want to kiss you",
            LocalDateTime.of(
                LocalDate.of(2023, 1, 16),
                LocalTime.of(11, 45)),
            wizardKostyshen, owlKostyshen, wizardSara);

    return args -> {
      wizardRepository.save(wizardKostyshen);
      wizardRepository.save(wizardSara);

      owlRepository.save(owlKostyshen);
      letterRepository.save(letterToSaraFromKostyshen);
    };
  }
}
