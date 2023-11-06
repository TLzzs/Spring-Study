package com.ludistudy.jpa;

import com.ludistudy.jpa.dao.StudentDAO;
import com.ludistudy.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    //after loaded the bean will automatically trigger commandLineRunner method
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("creating new student object...");
        Student tempStudent = new Student("DI", "LU", "di@123.com");

        //save the student object
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        //display id of the saved student
        System.out.println("Saved Student generated id : " + tempStudent.getId());
    }
}
