package com.example.owlmail.model.letter;

import static org.junit.jupiter.api.Assertions.*;

import com.example.owlmail.OwlMailApplication;
import com.example.owlmail.controllers.LetterDto;
import com.example.owlmail.model.owl.Owl;
import com.example.owlmail.model.owl.OwlBreed;
import com.example.owlmail.model.owl.OwlNotFoundException;
import com.example.owlmail.model.owl.OwlRepository;
import com.example.owlmail.model.wizard.Wizard;
import com.example.owlmail.model.wizard.WizardId;
import com.example.owlmail.model.wizard.WizardNotFoundException;
import com.example.owlmail.model.wizard.WizardRepository;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {OwlMailApplication.class})
class LetterServiceTest {

  @Autowired
  private OwlRepository owlRepository;

  @Autowired
  private WizardRepository wizardRepository;

  @Autowired
  private LetterService cut;


  @BeforeEach
  void initData(){
    wizardRepository.save(new Wizard("harry", "jordan", null));
    wizardRepository.save(new Wizard("chris", "webber", null));

    owlRepository.save(new Owl(null, "Luke", OwlBreed.SCOPS_OWL, null, null, null));
    owlRepository.save(new Owl(null, "Hedwig", OwlBreed.BARRED_OWL, null, null, null));
  }

  public static Stream<Arguments> provideNonExistingOwlArguments() {
    LetterDto letterDto1 = new LetterDto();
    letterDto1.setSender(new WizardId("harry", "jordan"));
    letterDto1.setReceiver(new WizardId("chris", "webber"));
    letterDto1.setOwlId(3L);

    LetterDto letterDto2 = new LetterDto();
    letterDto2.setSender(new WizardId("harry", "jordan"));
    letterDto2.setReceiver(new WizardId("chris", "webber"));
    letterDto2.setOwlId(99L);

    return Stream.of(
        Arguments.arguments(letterDto1, letterDto2));
  }


  @ParameterizedTest
  @MethodSource(value = "provideNonExistingOwlArguments")
  void failWhenOwlNotExists(LetterDto letterDto){
    assertThrows(OwlNotFoundException.class, ()->cut.createLetter(letterDto));
  }

  public static Stream<Arguments> provideNonExistingWizardArguments() {
    LetterDto letterDto1 = new LetterDto();
    letterDto1.setSender(new WizardId("harry", "jordan"));
    letterDto1.setReceiver(new WizardId("chris", "jordan"));
    letterDto1.setOwlId(1L);

    LetterDto letterDto2 = new LetterDto();
    letterDto2.setSender(new WizardId("harry", "webber"));
    letterDto2.setReceiver(new WizardId("chris", "webber"));
    letterDto2.setOwlId(2L);

    return Stream.of(
        Arguments.arguments(letterDto1, letterDto2));
  }

  @ParameterizedTest
  @MethodSource(value = "provideNonExistingWizardArguments")
  void failWhenWizardNotExists(LetterDto letterDto){
    assertThrows(WizardNotFoundException.class, ()->cut.createLetter(letterDto));
  }

  public static Stream<Arguments> provideCorrectArguments() {
    LetterDto letterDto1 = new LetterDto();
    letterDto1.setSender(new WizardId("harry", "jordan"));
    letterDto1.setReceiver(new WizardId("chris", "webber"));
    letterDto1.setOwlId(2L);

    LetterDto letterDto2 = new LetterDto();
    letterDto2.setSender(new WizardId("harry", "jordan"));
    letterDto2.setReceiver(new WizardId("harry", "jordan"));
    letterDto2.setOwlId(1L);

    return Stream.of(
        Arguments.arguments(letterDto1, letterDto2));
  }


  @ParameterizedTest
  @MethodSource(value = "provideCorrectArguments")
  void correctWhenOkay(LetterDto letterDto){
    assertDoesNotThrow(()->cut.createLetter(letterDto));
  }
}