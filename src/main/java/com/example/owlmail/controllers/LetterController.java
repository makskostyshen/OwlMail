package com.example.owlmail.controllers;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterDtoValidator;
import com.example.owlmail.model.letter.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
@RequestMapping(value = "/letter")
public class LetterController {

  private final LetterService letterService;
  private final LetterDtoValidator letterDtoValidator;


  @Autowired
  public LetterController(LetterService letterService, LetterDtoValidator letterDtoValidator) {
    this.letterService = letterService;
    this.letterDtoValidator = letterDtoValidator;
  }

  @GetMapping(value = "/{id}")
  public Letter getLetter(@PathVariable Long id) {
    return letterService.findById(id);
  }

  /**
   * Method for creating letter.
   *
   * @return LetterDto of saved letter in database.
   */
  @PostMapping
  public LetterDto createLetter(@RequestBody LetterDto letterDto) {
    letterDtoValidator.validate(letterDto);
    Letter letter = letterService.createLetter(letterDto);
    return new LetterDto(letter);
  }
}
