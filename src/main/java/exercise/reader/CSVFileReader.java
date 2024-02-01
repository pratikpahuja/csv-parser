package exercise.reader;

import exercise.addressbookparser.LineParser;
import exercise.model.AddressBookItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class CSVFileReader {

  LineParser parser;
  int noOfItemsInARow;

  public CSVFileReader(LineParser parser, int noOfItemsInARow) {
    this.parser = parser;
    this.noOfItemsInARow = noOfItemsInARow;
  }

  public void readCSV(String file, Consumer<AddressBookItem> resultCapturer) {
    try (var br = prepareBufferReader(file)) {
      String line;
      while ((line = br.readLine()) != null) {
        if (!isValidLineSyntax(line))
          continue;

        parser.parseLine(line)
          .ifPresent(resultCapturer);
      }
    } catch (Exception e) {
      System.err.println("Exception raised while trying to read file at location: " + file + ", exception message: " + e.getMessage());
    }
  }

  private boolean isValidLineSyntax(String line) {
    if (line.split(",").length != noOfItemsInARow) {
      System.err.println("Invalid line found, items != " + noOfItemsInARow +": " + line);

      return false;
    }

    return true;
  }

  private BufferedReader prepareBufferReader(String file) {
    return new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + file)));
  }

}
