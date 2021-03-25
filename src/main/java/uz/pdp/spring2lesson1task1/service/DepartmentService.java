package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task1.entity.Department;
import uz.pdp.spring2lesson1task1.payload.DepartmentDTO;
import uz.pdp.spring2lesson1task1.payload.Result;

import java.util.List;

@Service
public interface DepartmentService {

    ResponseEntity<Result> save(DepartmentDTO departmentDTO);                   // CREATE

    ResponseEntity<List<Department>> findAll();                                 // READ

    ResponseEntity<Department> findById(Integer id);                            // READ ONE

    ResponseEntity<Result> update(DepartmentDTO departmentDTO, Integer id);     // UPDATE

    ResponseEntity<Result> delete(Integer id);                                  // DELETE

}
