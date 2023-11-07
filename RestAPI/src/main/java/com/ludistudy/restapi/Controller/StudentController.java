package com.ludistudy.restapi.Controller;

import com.ludistudy.restapi.Entity.Student;
import com.ludistudy.restapi.Exception.StudentErrorResponse;
import com.ludistudy.restapi.Exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<Student> students;

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("DI", "LU"));
        students.add(new Student("HUAFANG" , "MAI"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list, keep it simple for now

        //check the studentId again list size

        if ((studentId >= students.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student Id not found - "+ studentId);
        }
        return students.get(studentId);
    }

}
