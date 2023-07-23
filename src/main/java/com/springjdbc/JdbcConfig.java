package com.springjdbc;

import com.springjdbc.dao.PersonDao;
import com.springjdbc.entities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {

    //DataSource bean
    @Bean
    public DriverManagerDataSource getDs() {

        String driverClassName = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1524:orcl2";
        String username = "scott";
        String password = "system";

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

    //JdbcTemplate bean
    @Bean
    public JdbcTemplate getTemplate() {

        JdbcTemplate template = new JdbcTemplate(getDs());

        return template;
    }

    //StudentDao bean
    @Bean
    public PersonDao getDao() {

        PersonDao personDao = new PersonDao(getTemplate());

        return personDao;
    }

    //Student bean
    @Bean
    public Person getPerson() {

        Person p = new Person(79846, "Swapan", "Bangalore");

        return p;
    }
}
