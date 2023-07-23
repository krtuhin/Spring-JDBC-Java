package com.springjdbc.dao;

import com.springjdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao implements Dao {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //insert method body
    @Override
    public int insert(Student student) {

        String query = "insert into student(id, name, city) values(?, ?, ?)";

        int result = template.update(query, student.getId(), student.getName(), student.getCity());

        return result;
    }

    //update method body
    @Override
    public int change(Student student) {

        String query = "update student set name=?, city=? where id=?";

        int result = this.template.update(query, student.getName(), student.getCity(), student.getId());

        return result;
    }
}
