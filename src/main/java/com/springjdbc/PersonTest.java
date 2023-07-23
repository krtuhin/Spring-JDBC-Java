package com.springjdbc;

import com.springjdbc.dao.PersonDao;
import com.springjdbc.entities.Person;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {

    public static void main(String[] args) {

        //declare IoC
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        //get person dao class from IoC container
        PersonDao dao = context.getBean("getDao", PersonDao.class);

        //get person object from IoC container
        Person person = context.getBean("getPerson", Person.class);

        //inserting person into database
        int r = dao.insert(person);

        System.out.println("Inserted: " + person);

        //update person
        int res = dao.change(person);

        System.out.println("Updated : " + person);

        //deleting person by id
        int result = dao.delete(673);

        System.out.println("Deleted....!");

        //selecting single person by id
        Person p = dao.getPerson(213);

        System.out.println("Selected : " + p);

        //selecting multiple person
        List<Person> persons = dao.getPersons();

        System.out.println("Selected : " + persons);
    }
}
