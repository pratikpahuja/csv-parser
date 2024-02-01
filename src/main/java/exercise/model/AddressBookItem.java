package exercise.model;

import java.time.LocalDate;

public class AddressBookItem {
  private final String name;
  private final Gender gender;
  private final LocalDate dateOfBirth;

  public AddressBookItem(String name, Gender gender, LocalDate dateOfBirth) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }
}