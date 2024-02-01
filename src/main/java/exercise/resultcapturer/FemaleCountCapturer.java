package exercise.resultcapturer;

import exercise.model.AddressBookItem;
import exercise.model.Gender;

import java.util.function.Consumer;

public class FemaleCountCapturer implements Consumer<AddressBookItem> {
  private int noOfFemale;

  public void accept(AddressBookItem item) {
    if (item.getGender() == Gender.FEMALE)
      noOfFemale++;
  }

  public int getNoOfFemale() {
    return noOfFemale;
  }
}