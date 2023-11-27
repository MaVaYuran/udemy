package by.maria.hibstarter.converter;

import by.maria.hibstarter.entity.Birthday;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.util.Optional;

public class BirthdayConverter implements AttributeConverter<Birthday, Date> {
    @Override
    public Date convertToDatabaseColumn(Birthday birthday) {
        return Optional.ofNullable(birthday)
                .map(Birthday::birthDate)// через метод получаем дату
                .map(Date::valueOf)//преобразуем ее в нужный нам тип
                .orElse(null);//если birthday null
    }

    @Override
    public Birthday convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date)
                .map(Date::toLocalDate)// получаем дату
                .map(Birthday::new)//создаем новый экземпляр класса
                .orElse(null);
    }
}
