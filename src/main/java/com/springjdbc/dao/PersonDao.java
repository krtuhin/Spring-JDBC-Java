package com.springjdbc.dao;

import com.springjdbc.entities.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("getDao")
public class PersonDao implements Pdao {

    //JDBC Template for database operation
    @Autowired
    private JdbcTemplate template;

    public PersonDao(JdbcTemplate template) {
        this.template = template;
    }

    //method for insert operation
    @Override
    public int insert(Person person) {

        String q = "insert into person(id, name, address) values(?, ?, ?)";

        int res = this.template.update(q, person.getId(), person.getName(), person.getAddress());

        return res;
    }

    //method for update operation
    @Override
    public int change(Person person) {

        String q = "update person set name = ?, address = ? where id = ?";

        int r = this.template.update(q, person.getName(), person.getAddress(), person.getId());

        return r;
    }

    //method for delete operation
    @Override
    public int delete(int id) {

        String q = "delete from person where id = ?";

        int r = this.template.update(q, id);

        return r;
    }

    //method for select single Person
    @Override
    public Person getPerson(int id) {

        String q = "select * from person where id = ?";

        Person person = this.template.queryForObject(q, new RowMapperPerson(), id);

        return person;
    }

    //method for select multiple persons
    @Override
    public List<Person> getPersons() {

        String q = "select * from person";

        List<Person> persons = this.template.query(q, new RowMapperPerson());

        return persons;
    }
}
