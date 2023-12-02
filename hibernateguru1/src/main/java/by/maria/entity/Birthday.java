package by.maria.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public record Birthday(LocalDate birthDate) {
public long getAge() {
   return ChronoUnit.YEARS.between(birthDate, LocalTime.now());
}
}
