package config;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    private static Configuration configuration;

    public static Configuration getConfiguration() {
        if (configuration == null) {
            try {
                configuration = new Configuration();
                // set of properties
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost/hb_one_to_one");
                properties.put(Environment.USER, "hbstudent");
                properties.put(Environment.PASS, "hbstudent");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, true);
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "org.hibernate.context.internal.ThreadLocalSessionContext");
                // apply properties
                configuration.setProperties(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return configuration;
    }
}
