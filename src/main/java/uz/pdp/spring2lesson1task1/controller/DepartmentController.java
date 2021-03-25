package uz.pdp.spring2lesson1task1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task1.entity.Department;
import uz.pdp.spring2lesson1task1.payload.DepartmentDTO;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.service.DepartmentService;
import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.save(departmentDTO);
    }

    @GetMapping()
    public ResponseEntity<List<Department>> get(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getOne(@PathVariable Integer id){
        return departmentService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAddress(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.update(departmentDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteAddress(@PathVariable Integer id){
        return departmentService.delete(id);
    }
}
