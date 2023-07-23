package com.springjdbc;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context
                = new ClassPathXmlApplicationContext("com/config/config.xml");

        //getting template object from IoC container
        JdbcTemplate jdbcTemplate
                = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //student object from IoC
        Student student = context.getBean("st", Student.class);

        //student dao class from IoC container
        StudentDao studentDao = context.getBean("std", StudentDao.class);

        //call insert method
        int result = studentDao.insert(student);

        System.out.println("Inserted: " + student);

        //another student object from IoC
        Student st = context.getBean("student", Student.class);

        //call student dao's update method
        int result1 = studentDao.change(st);

        System.out.println("Updated...!");

        //call delete method from student dao
        int result2 = studentDao.delete(75546);

        System.out.println("Deleted..!");
    }
}
