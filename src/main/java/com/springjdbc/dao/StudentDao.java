package com.springjdbc.dao;

import com.springjdbc.entities.Student;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    //delete method body
    @Override
    public int delete(int id) {

        String query = "delete from student where id=?";

        int result = this.template.update(query, id);

        return result;
    }

    //select single object method
    @Override
    public Student getStudent(int id) {

        String query = "select * from student where id=?";

        //instantiate row mapper class (child class object into parent class variable)
        RowMapper<Student> rowMapper = new RowMapperClass();

        //fire select query for single student
        Student student = this.template.queryForObject(query, rowMapper, id);

        return student;
    }

    //select multiple objects method
    @Override
    public List<Student> getStudents() {

        String query = "select * from student";

        List<Student> list = this.template.query(query, new RowMapperClass());

        return list;
    }
}
