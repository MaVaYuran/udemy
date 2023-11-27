package by.maria.hibstarter.entity;

import by.maria.hibstarter.converter.BirthdayConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    private String username;
    @Embedded
    private PersonalInfo personalInfo;
    @Enumerated(EnumType.STRING)
    Role role;
}
