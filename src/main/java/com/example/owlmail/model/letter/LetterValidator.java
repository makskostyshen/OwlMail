package com.example.owlmail.model.letter;

import com.example.owlmail.controllers.LetterDto;
import com.example.owlmail.model.letter.exceptions.InvalidBodyException;
import com.example.owlmail.model.letter.exceptions.InvalidHeaderException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class LetterValidator {
  private static final short MAX_BODY_SIZE = 500;
  private static final short MAX_HEADER_SIZE = 50;

  public void validate(LetterDto letterDto){
    if (letterDto.getBody().length() > MAX_BODY_SIZE){
      throw new InvalidBodyException();
    }
    if (letterDto.getHeader().length() > MAX_HEADER_SIZE){
      throw new InvalidHeaderException();
    }
  }
}
