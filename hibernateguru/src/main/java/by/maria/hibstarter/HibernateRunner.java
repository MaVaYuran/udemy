package by.maria.hibstarter;

import by.maria.hibstarter.converter.BirthdayConverter;
import by.maria.hibstarter.entity.*;
import by.maria.hibstarter.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.*;

import java.time.LocalDate;
@Slf4j
public class HibernateRunner {
//nastraivaem log
   // private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);
    public static void main(String[] args) {
//        User user =User.builder()
//                .username("ivan52@mail.ru")
//                .personalInfo(PersonalInfo.builder()
//                        .firstname("Ivan")
//                        .lastname("Ivanov")
//                        .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
//                        .build())
//                .role(Role.ADMIN)
//                .build();
        User1 user1 =User1.builder()
                .username("ivan52@mail.ru")
                .personalInfo(PersonalInfo1.builder()
                        .firstname("Ivan")
                        .lastname("Ivanov")
                        .birthDate(new Birthday(LocalDate.of(2000, 01, 01)))
                        .build())
                .role(Role.ADMIN)
                .build();
       // log.info("user object in transient state: {}", user);//можно писать много фиг. скобок  и users
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user1);

//            //User user1 = session.get(User.class, "ivan@mail.ru");
//            user.setFirstname("Vut");
//            log.warn("user firstname is changed: {}", user);
//            session.clear();//удаляет все энтити из кэша
//           // session.evict(user1); удаляет конкретный объект
//            System.out.println(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            log.error("Exception occured: " + e);
            throw e;
        }
    }
}
