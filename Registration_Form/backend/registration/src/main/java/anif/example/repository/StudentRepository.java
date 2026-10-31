package anif.example.repository;

import anif.example.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity , Long>
{
    boolean existsByEmail(String email);
    boolean existsByMobile(String mobile);
    
}