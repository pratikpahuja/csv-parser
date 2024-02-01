package exercise.addressbookparser.parser;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class DateOfBirthParser implements CSVItemParser<LocalDate> {
  @Override
  public LocalDate apply(String data) {
    try {
      return parse(data.trim());
    } catch (RuntimeException e) {
      throw new ParseException("DOB", data, e.getMessage());
    }
  }
}
