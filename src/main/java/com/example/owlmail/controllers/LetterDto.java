package com.example.owlmail.controllers;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.wizard.WizardId;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LetterDto {
  private Long id;
  private String header;
  private String body;

  private LocalDateTime dateTime;

  private WizardId sender;
  private Long owlId;
  private WizardId receiver;

  public LetterDto(Letter letter) {
    id = letter.getId();
    header = letter.getHeader();
    body = letter.getBody();
    dateTime = letter.getDateTime();

    sender = letter.getSender().getWizardId();
    owlId = letter.getOwl().getId();
    receiver = letter.getReceiver().getWizardId();
  }
}
