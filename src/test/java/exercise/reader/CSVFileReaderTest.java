package exercise.reader;

import exercise.addressbookparser.LineParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class CSVFileReaderTest {

  CSVFileReader reader;
  private LineParser parser;
  private Consumer consumer;

  @BeforeEach
  void setup() {
    parser = mock(LineParser.class);
    consumer = mock(Consumer.class);
    reader =  new CSVFileReader(parser, 4);
  }

  @Test
  void fileReadError() {
    reader.readCSV("unknown.csv", consumer);

    verifyNoInteractions(parser, consumer);
  }

  @Test
  void fileValidationFails() {
    reader.readCSV("incorrect_no_of_items.csv", consumer);

    verifyNoInteractions(parser, consumer);
  }
}