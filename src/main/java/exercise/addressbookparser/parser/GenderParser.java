package exercise.addressbookparser.parser;

import exercise.model.Gender;

import static exercise.model.Gender.fromString;

public class GenderParser implements CSVItemParser<Gender> {
  @Override
  public Gender apply(String data) {
    try {
      return fromString(data);
    } catch (RuntimeException e) {
      throw new ParseException("gender", data, e.getMessage());
    }
  }
}
