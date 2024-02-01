package exercise.addressbookparser.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateOfBirthParserTest {

  DateOfBirthParser parser;

  @BeforeEach
  void setup() {
    parser = new DateOfBirthParser();
  }

  @Test
  void validDateParse() {
    assertEquals(LocalDate.of(2024, 1, 4), parser.apply("2024-01-04"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"asd", "123", "01-01-32"})
  void invalidDateParse(String data) {
    assertThrows(ParseException.class, () -> parser.apply(data));
  }

}