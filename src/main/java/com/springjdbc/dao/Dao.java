package com.springjdbc.dao;

import com.springjdbc.entities.Student;
import java.util.List;

public interface Dao {

    //insert method
    public int insert(Student student);

    //update method
    public int change(Student student);

    //delete method
    public int delete(int id);

    //select single object
    public Student getStudent(int id);

    //select multiple objects
    public List<Student> getStudents();
}
