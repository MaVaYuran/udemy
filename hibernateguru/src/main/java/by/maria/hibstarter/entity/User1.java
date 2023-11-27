package by.maria.hibstarter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users1")
public class User1 {
//primary key by 3 fields
    private String username;
    @EmbeddedId
    private PersonalInfo1 personalInfo;
    @Enumerated(EnumType.STRING)
    Role role;
}