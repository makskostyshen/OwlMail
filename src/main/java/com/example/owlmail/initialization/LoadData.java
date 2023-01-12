package com.example.owlmail.initialization;

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

  @Autowired
  public LoadData(MagicianRepository magicianRepository, OwlRepository owlRepository) {
    this.magicianRepository = magicianRepository;
    this.owlRepository = owlRepository;
  }

  /**
   * Load initial data into database.
   */
  @Bean
  public CommandLineRunner loadDatabase() {
    return args -> {
      magicianRepository.save(new Magician(null, "Maks", "Kostyshen"));
      magicianRepository.save(new Magician(null, "Art", "Kostyshen"));

      owlRepository.save(new Owl("Gedviga", OwlBreed.BASIC, OwlColor.GRAY));
    };
  }
}
