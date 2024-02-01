package exercise.addressbookparser.parser;

public class NameParser implements CSVItemParser<String> {
  @Override
  public String apply(String data) {
    return data.trim();
  }
}
