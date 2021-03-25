package uz.pdp.spring2lesson1task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring2lesson1task1.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    boolean existsByName(String string);
}
