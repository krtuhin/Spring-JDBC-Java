package com.springjdbc.dao;

import com.springjdbc.entities.Person;
import java.util.List;

public interface Pdao {

    //insert method
    public int insert(Person person);

    //update method
    public int change(Person person);

    //delete method
    public int delete(int id);

    //select single object method
    public Person getPerson(int id);

    //select multiple objects method
    public List<Person> getPersons();
}
