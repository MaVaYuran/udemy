package by.maria.hibstarter.util;

import by.maria.hibstarter.converter.BirthdayConverter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(new BirthdayConverter(), true);
//        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }
}