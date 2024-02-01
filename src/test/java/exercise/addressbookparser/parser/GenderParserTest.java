package exercise.addressbookparser.parser;

import exercise.model.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenderParserTest {

  GenderParser parser;

  @BeforeEach
  void setup() {
    parser = new GenderParser();
  }

  @ParameterizedTest
  @ValueSource(strings = {"male", "Male", "maLe"})
  void testCaseInsensitivity(String data) {
    assertEquals(Gender.MALE, parser.apply(data));
  }

}