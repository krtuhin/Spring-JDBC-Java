package com.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBC {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("com/config/config.xml");

        //getting template object from IoC container
        JdbcTemplate jdbcTemplate
                = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //insert query (static)
        String query = "insert into student(id, name, city) values(35653, 'Varun', 'Delhi')";

        //insert query dynamic
        String query1 = "insert into student(id, name, city) values(?,?,?)";

        //fire query
        int result = jdbcTemplate.update(query1, 678678, "Raju", "Kanpur");

        System.out.println("Number of row inserted: " + result);
    }
}
