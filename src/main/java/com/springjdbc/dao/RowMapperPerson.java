package com.springjdbc.dao;

import com.springjdbc.entities.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperPerson implements RowMapper<Person> {

    //convert result set into Person Onject
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

        Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));

        return person;
    }
}
