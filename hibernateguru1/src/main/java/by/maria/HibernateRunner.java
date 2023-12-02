package by.maria;

import by.maria.entity.*;
import by.maria.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) throws NoSuchFieldException {
       Company company = Company.builder()
                .name("Allot")
                .build();
        User user = User.builder()
                .username("ivan1@mail.ru")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Dima")
                        .lastname("Ivanov")
                        .birthDate(new Birthday(LocalDate.of(1991, 6, 12)))
                        .build())
                .role(Role.USER)
                .company(company)
                .build();
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                // session.saveOrUpdate(company);//не нужно при cascade.type.all
                session.saveOrUpdate(user);
//                var user2 = session.get(User.class, 2);
//                session.delete(user2);

                session.getTransaction().commit();
            }
        }
    }
}
