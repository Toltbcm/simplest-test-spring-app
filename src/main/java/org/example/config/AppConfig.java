package org.example.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    private DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/test_db");
        dataSource.setDefaultSchema("test_schema");
        dataSource.setUsername("test_user");
        dataSource.setPassword("test_password");

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        properties.put(Environment.FORMAT_SQL, false);
        properties.put(Environment.USE_SQL_COMMENTS, true);
        properties.put(Environment.HIKARI_MAX_SIZE, 10);

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("org.example.model");

        return localSessionFactoryBean;
    }
}
