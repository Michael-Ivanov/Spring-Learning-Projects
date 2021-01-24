package miv.study.config;

import miv.study.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // set of properties
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost/hb_student_tracker");
                properties.put(Environment.USER, "hbstudent");
                properties.put(Environment.PASS, "hbstudent");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, true);
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.hibernate.context.internal.ThreadLocalSessionContext");
                // apply properties
                configuration.setProperties(properties);
                // add annotated class
                configuration.addAnnotatedClass(Student.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
