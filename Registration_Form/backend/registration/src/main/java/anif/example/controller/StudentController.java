
package anif.example.controller;

import anif.example.service.StudentService;
import jakarta.validation.Valid;
import anif.example.entity.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @PostMapping("/register")
public StudentEntity registerStudent(@Valid @RequestBody StudentEntity student) {
    try {
        return studentService.register(student);
    } catch (IllegalArgumentException e) {
        throw new ResponseStatusException(
            HttpStatus.CONFLICT,
            e.getMessage()
        );
    }
}
}
