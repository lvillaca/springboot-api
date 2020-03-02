package luis.sample.config;

import java.util.Properties;

public class ConfigProperties {

    final static String MODEL_PACKAGE = "luis.sample.dados";

    final static Properties JPA_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        put("hibernate.hbm2ddl.auto", "none");
        put("hibernate.ddl-auto", "none");
        put("show-sql", "true");
    }};
}
