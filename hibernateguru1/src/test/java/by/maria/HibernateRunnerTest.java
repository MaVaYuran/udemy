package by.maria;

import by.maria.converter.BirthdayConverter;
import by.maria.entity.*;
import by.maria.util.HibernateUtil;
import lombok.Cleanup;
import org.junit.Test;

import java.time.LocalDate;

public class HibernateRunnerTest {
    @Test
    public void checkManyToMany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        Chat chat = Chat.builder()
                .name("java")
                .build();
        User user = session.get(User.class, 7);
        user.addChat(chat);

        session.save(chat);

        session.getTransaction().commit();

    }

    @Test
    public void checkOneToOne() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        User user = User.builder()
                .username("Ivaan1@mail.ru")
                .build();
        Profile profile = Profile.builder()
                .street("Pobedy 1")
                .language("RU")
                .build();
        session.save(user);
        profile.setUser(user);
        session.save(profile);
        session.getTransaction().commit();
    }

    @Test
    public void checkOrphalRemoval() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();
                Company company = session.get(Company.class, 7);
                company.getUsers().removeIf(user -> user.getId().equals(6));
                session.getTransaction().commit();
            }
        }
    }

    @Test
    public void addNewUserAndCompany() {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = Company.builder()
                .name("Yandex")
                .build();
        User user = User.builder()
                .username("vasya@yandex.ru")
                .build();
        company.addUser(user);
        session.save(company);
        session.getTransaction().commit();
    }

    @Test
    public void checkOneToMany() {
        try (var sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (var session = sessionFactory.openSession()) {
                session.beginTransaction();
                var company = session.get(Company.class, 1);
                System.out.println(company.getUsers());
                session.getTransaction().commit();
            }
        }
    }
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
