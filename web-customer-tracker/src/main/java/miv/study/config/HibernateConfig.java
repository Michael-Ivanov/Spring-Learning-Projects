package miv.study.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.beans.PropertyVetoException;
import java.util.Properties;

public class HibernateConfig {
    private static Configuration configuration;
    private static ComboPooledDataSource cpds;

    public static Configuration getConfiguration() {
        if (configuration == null) {
            try {
                configuration = new Configuration();
                // set of properties
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "miv.study.jdbc:postgresql://localhost/web_customer_tracker");
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
