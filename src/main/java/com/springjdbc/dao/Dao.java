package com.springjdbc.dao;

import com.springjdbc.entities.Student;

public interface Dao {

    //insert method
    public int insert(Student student);

    //update method
    public int change(Student student);

    //delete method
    public int delete(int id);
}
