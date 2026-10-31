
package anif.example.service;

import anif.example.entity.StudentEntity;
import anif.example.repository.StudentRepository;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

   public StudentEntity register(StudentEntity student) {

    System.out.println("Checking email...");

    if (studentRepository.existsByEmail(student.getEmail())) {
        System.out.println("Email already exists!");
        throw new IllegalArgumentException("Email is already registered");
    }

    System.out.println("Checking mobile...");

    if (studentRepository.existsByMobile(student.getMobile())) {
        System.out.println("Mobile already exists!");
        throw new IllegalArgumentException("Mobile number already registered");
    }

    System.out.println("Saving student...");

    return studentRepository.save(student);
}
}

