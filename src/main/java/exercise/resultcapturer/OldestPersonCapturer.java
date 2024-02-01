package exercise.resultcapturer;

import exercise.model.AddressBookItem;

import java.util.Optional;
import java.util.function.Consumer;

import static java.util.Optional.*;

public class OldestPersonCapturer implements Consumer<AddressBookItem> {
    private Optional<AddressBookItem> oldestPerson = empty();

    public void accept(AddressBookItem item) {
      //Either oldestPerson is empty
      // or oldestPerson' dateOfBirth is after item's date of birth.
      if (oldestPerson.isEmpty()
        || oldestPerson.get().getDateOfBirth().isAfter(item.getDateOfBirth()))
        oldestPerson = of(item);

    }

    public String getOldestPersonName() {
      return oldestPerson
        .map(AddressBookItem::getName)
        .orElse("");
    }
  }