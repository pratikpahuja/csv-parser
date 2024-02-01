package exercise.addressbookparser;

import exercise.addressbookparser.parser.*;
import exercise.model.AddressBookItem;
import exercise.model.Gender;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class LineParser {
  private static final int NAME_COLUMN_INDEX = 0;
  private static final int GENDER_COLUMN_INDEX = 1;
  private static final int DOB_COLUMN_INDEX = 2;

  private static final Map<Integer, CSVItemParser<?>> parserMap = Map.of(
    NAME_COLUMN_INDEX, new NameParser(),
    GENDER_COLUMN_INDEX, new GenderParser(),
    DOB_COLUMN_INDEX, new DateOfBirthParser()
  );

  public Optional<AddressBookItem> parseLine(String line) {
    var attrs = line.split(",");

    try {
      var name = parse(attrs, NAME_COLUMN_INDEX, String.class);
      var gender = parse(attrs, GENDER_COLUMN_INDEX, Gender.class);
      var dateOfBirth = parse(attrs, DOB_COLUMN_INDEX, LocalDate.class);

      return Optional.of(new AddressBookItem(name, gender, dateOfBirth));
    } catch(ParseException e) {
      System.err.println("Parse error occurred in line: " + line + ", exception: " + e.getMessage());
    } catch (RuntimeException e) {
      System.err.println("Unknown error occurred in line: " + line + ", exception: " + e.getMessage());
    }

    return Optional.empty();
  }

  private <T> T parse(String[] attrs, int csvItemIndex, Class<T> clazz) {
    return ((CSVItemParser<T>) parserMap.get(csvItemIndex)).apply(attrs[csvItemIndex]);
  }
}
