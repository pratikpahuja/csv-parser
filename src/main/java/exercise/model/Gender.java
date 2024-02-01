package exercise.model;

public enum Gender {
    MALE, FEMALE;

    public static Gender fromString(String genderStr) {
      for (var gender: Gender.values()) {
        if (genderStr.trim().equalsIgnoreCase(gender.name()))
          return gender;
      }

      throw new IllegalArgumentException("Invalid gender supplied. " + genderStr);
    }
  }