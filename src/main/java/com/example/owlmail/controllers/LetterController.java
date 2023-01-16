package com.example.owlmail.controllers;

import com.example.owlmail.model.letter.Letter;
import com.example.owlmail.model.letter.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class.
 */
@RestController
@RequestMapping(value = "/letter")
public class LetterController {

  private final LetterService letterService;

  @Autowired
  public LetterController(LetterService letterService) {
    this.letterService = letterService;
  }

  @GetMapping(value = "/{id}")
  public Letter getLetter(@PathVariable Long id) {
    return letterService.findById(id);
  }
}
