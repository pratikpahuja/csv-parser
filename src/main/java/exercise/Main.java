package exercise;


import exercise.addressbookparser.LineParser;
import exercise.model.AddressBookItem;
import exercise.reader.CSVFileReader;
import exercise.resultcapturer.FemaleCountCapturer;
import exercise.resultcapturer.OldestPersonCapturer;

import java.util.function.Consumer;

public class Main {


  public static void main(String[] args) {
    var csvReader = new CSVFileReader(new LineParser(), 3);

    var femaleCountCapturer = new FemaleCountCapturer();
    var oldestPersonCapturer = new OldestPersonCapturer();

    var resultCapturerChain = prepareResultChain(femaleCountCapturer, oldestPersonCapturer);

    csvReader.readCSV( "address-book.csv", resultCapturerChain);

    System.out.println("Number of females inside address book: " + femaleCountCapturer.getNoOfFemale());
    System.out.println("Oldest person inside address book: " + oldestPersonCapturer.getOldestPersonName());
  }

  @SafeVarargs
  static Consumer<AddressBookItem> prepareResultChain(Consumer<AddressBookItem> initResultCapturer,
                                                      Consumer<AddressBookItem>... resultCapturers) {
    var resultCapturerChain = initResultCapturer;


    for(var capturer: resultCapturers)
      resultCapturerChain = resultCapturerChain.andThen(capturer);

    return resultCapturerChain;
  }
}
