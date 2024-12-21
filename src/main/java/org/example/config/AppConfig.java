package org.example.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:application.properties")
public class AppConfig {
    private Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    private DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(environment.getProperty("db.driver"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setDefaultSchema(environment.getProperty("db.schema"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL,
                environment.getProperty("hibernate.show_sql"));
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL,
                environment.getProperty("hibernate.format_sql"));
        properties.put(org.hibernate.cfg.Environment.USE_SQL_COMMENTS,
                environment.getProperty("hibernate.use_sql_comments"));
        properties.put(org.hibernate.cfg.Environment.HIKARI_MAX_SIZE,
                environment.getProperty("hibernate.maximumPoolSize"));
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO,
                environment.getProperty("hibernate.hbm2ddl.auto"));

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("org.example.model");

        return localSessionFactoryBean;
    }
}
