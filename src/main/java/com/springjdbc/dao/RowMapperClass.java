package com.springjdbc.dao;

import com.springjdbc.entities.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperClass implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        //convert resultset into student object
        Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3));

        return student;
    }
}
