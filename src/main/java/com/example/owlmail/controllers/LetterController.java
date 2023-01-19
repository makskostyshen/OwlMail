package com.example.owlmail.controllers;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterService;
import com.example.owlmail.model.letter.LetterValidator;
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
  private final LetterValidator letterValidator;


  @Autowired
  public LetterController(LetterService letterService, LetterValidator letterValidator) {
    this.letterService = letterService;
    this.letterValidator = letterValidator;
  }

  @GetMapping(value = "/{id}")
  public Letter getLetter(@PathVariable Long id) {
    return letterService.findById(id);
  }

  @PostMapping
  public LetterDto createLetter(@RequestBody LetterDto letterDto){
    letterValidator.validate(letterDto);
    Letter letter = letterService.createLetter(letterDto);
    return new LetterDto(letter);
  }
}
