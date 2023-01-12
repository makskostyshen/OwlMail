package com.example.owlmail.initialization;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterRepository;
import com.example.owlmail.model.magician.Magician;
import com.example.owlmail.model.magician.MagicianRepository;
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

  private final MagicianRepository magicianRepository;
  private final OwlRepository owlRepository;
  private final LetterRepository letterRepository;

  @Autowired
  public LoadData(MagicianRepository magicianRepository, OwlRepository owlRepository,
      LetterRepository letterRepository) {
    this.magicianRepository = magicianRepository;
    this.owlRepository = owlRepository;
    this.letterRepository = letterRepository;
  }

  /**
   * Load initial data into database.
   */
  @Bean
  public CommandLineRunner loadDatabase() {
    Magician magicianKostyshen = new Magician(null, "Maks", "Kostyshen");
    Magician magicianSara = new Magician(null, "Art", "Sara");

    Owl owlKostyshen = new Owl("Gedviga", OwlBreed.BASIC, OwlColor.GRAY, magicianKostyshen);
    Letter letterToSaraFromKostyshen =
        new Letter(null, "Attention!!", "I want to kiss you", magicianSara,
                                      owlKostyshen);
    return args -> {
      magicianRepository.save(magicianKostyshen);
      magicianRepository.save(magicianSara);

      owlRepository.save(owlKostyshen);
      letterRepository.save(letterToSaraFromKostyshen);
    };
  }
}
