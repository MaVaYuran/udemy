package by.maria.hibstarter;

import by.maria.hibstarter.entity.Birthday;
import by.maria.hibstarter.entity.User;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HibernateRunnerTest {
//    @Test
//    public void testHibernateApi() throws SQLException, IllegalAccessException {
//        User user = User.builder()
//                .username("ivan2@mail.ru")
//                .firstname("Ivan")
//                .lastname("Ivanov")
//                .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
//                .build();
//        var sql = """
//                insert into
//                %s
//                (%s)
//                values
//                (%s)
//                """;
//        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
//                .map(table ->  table.name())//ищем аннтацию table в классе user
//                .orElse(user.getClass().getName());//tableName идёт в первый %s
//
//        Field[] fields = user.getClass().getDeclaredFields();//получаем список полей
//        var columnNames = Arrays.stream(fields)
//                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
//                        .map(Column::name)//через аннотации
//                        .orElse(field.getName()))//через имя поля
//                .collect(Collectors.joining(",")
//                );//fieldNames add to (%s)
//
//        var columnValues = Arrays.stream(fields)
//                .map(field -> "?")
//                .collect(Collectors.joining(","));//подставляем значения на место последнего %s
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gurudb", "root", "root");
//        var statement = connection.prepareStatement(sql.formatted(tableName, columnNames, columnValues));
//        for (int i = 0; i < fields.length; i++) {
//            fields[i].setAccessible(true);
//            statement.setObject(i + 1, fields[i].get(user));
//        }
//        System.out.println(statement);
//        statement.executeUpdate();
//        statement.close();
//        connection.close();
//    }
//
}