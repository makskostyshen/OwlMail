package com.example.owlmail.initialization;

import com.example.owlmail.model.magician.Magician;
import com.example.owlmail.model.magician.MagicianRepository;
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

  @Autowired
  public LoadData(MagicianRepository magicianRepository) {
    this.magicianRepository = magicianRepository;
  }

  /**
   * Load initial data into database.
   */
  @Bean
  public CommandLineRunner loadDatabase() {
    return args -> {
      magicianRepository.save(new Magician(null, "Maks", "Kostyshen"));
      magicianRepository.save(new Magician(null, "Art", "Kostyshen"));
    };
  }
}
