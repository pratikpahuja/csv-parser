package exercise.addressbookparser.parser;

public class ParseException extends RuntimeException {

  public ParseException(String itemType, String itemValue, String message) {
    super("Unable to parse item: " + itemType + ", item value: " + itemValue + ", reason: " + message);
  }

}
