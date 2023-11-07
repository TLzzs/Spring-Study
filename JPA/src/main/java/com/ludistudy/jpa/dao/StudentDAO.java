package com.ludistudy.jpa.dao;

import com.ludistudy.jpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById (Integer id);

    List<Student> findAll ();

    List<Student> findByLastName (String theLastName);
}
