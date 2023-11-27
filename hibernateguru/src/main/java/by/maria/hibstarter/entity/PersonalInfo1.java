package by.maria.hibstarter.entity;


import by.maria.hibstarter.converter.BirthdayConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PersonalInfo1 implements Serializable {//primary key must be serializable
    //generate serialId. Важно, чтобы у объекта который сериализуется-десериализуется была одна версия
    @Serial
    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;
    @Convert(converter = BirthdayConverter.class)
    @Column(name="birth_date")
    private Birthday birthDate;

}
