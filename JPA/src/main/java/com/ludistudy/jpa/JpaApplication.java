package com.ludistudy.jpa;

import com.ludistudy.jpa.dao.StudentDAO;
import com.ludistudy.jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    //after loaded the bean will automatically trigger commandLineRunner method
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

//            readStudent(studentDAO);

//            queryForStudent(studentDAO);

            queryForStudentByLastName(studentDAO);
        };
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {
        //get a list of students
        List<Student> theStudents = studentDAO.findByLastName("LU");

        //display the list of students
        for (Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {

        //get a list of students

        List<Student> theStudents = studentDAO.findAll();

        //display list of students

        for (Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        //create a student object
        System.out.println("creating new student object...");
        Student student = new Student("Daffy", "Duck", "test@gmail.com");

        //save the student
        System.out.println("Saving the student");
        studentDAO.save(student);

        //display id of the student
        System.out.println("Saved Student generated id : " + student.getId());

        //retrieve student based on id
        Student myStudent = studentDAO.findById(student.getId());

        System.out.println("Found the student: "+myStudent);
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
