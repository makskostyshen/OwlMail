package com.example.owlmail.model.letter;

import com.example.owlmail.controllers.LetterDto;
import com.example.owlmail.model.letter.exceptions.LetterNotFoundException;
import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlService;
import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class.
 */
@Service
public class LetterService {
  private final OwlService owlService;
  private final WizardService wizardService;
  private final LetterRepository letterRepository;

  @Autowired
  public LetterService(OwlService owlService,
      WizardService wizardService, LetterRepository letterRepository) {
    this.owlService = owlService;
    this.wizardService = wizardService;
    this.letterRepository = letterRepository;
  }

  public Letter findById(Long id) {
    return letterRepository.findById(id).orElseThrow(LetterNotFoundException::new);
  }

  public Letter createLetter(LetterDto letterDto) {
    Wizard sender = wizardService.findByWizardId(letterDto.getSender());
    Wizard receiver = wizardService.findByWizardId(letterDto.getReceiver());
    Owl owl = owlService.findById(letterDto.getOwlId());

    Letter letter = new Letter();
    letter.setHeader(letterDto.getHeader());
    letter.setBody(letterDto.getBody());
    letter.setOwl(owl);
    letter.setSender(sender);
    letter.setReceiver(receiver);

    return letterRepository.save(letter);
  }
}
