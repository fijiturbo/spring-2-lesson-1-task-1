package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task1.entity.Department;
import uz.pdp.spring2lesson1task1.payload.DepartmentDTO;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.repository.CompanyRepository;
import uz.pdp.spring2lesson1task1.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ResponseEntity<Result> save(DepartmentDTO departmentDTO) {
        if (departmentRepository.existsByName(departmentDTO.getName())) {
            return ResponseEntity.ok(new Result("Bunday nomli kompaniya bor", false));
        } else if (companyRepository.existsById(departmentDTO.getCompany_id())) {
            Department department = new Department(departmentDTO.getName(), companyRepository.getOne(departmentDTO.getCompany_id()));
            departmentRepository.save(department);
            return ResponseEntity.ok(new Result("Department qo'shildi", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli kompaniya yo'q",false));
    }

    @Override
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @Override
    public ResponseEntity<Department> findById(Integer id) {
        if (departmentRepository.existsById(id)) {
            return ResponseEntity.ok(departmentRepository.getOne(id));
        }
        return ResponseEntity.ok(new Department());
    }

    @Override
    public ResponseEntity<Result> update(DepartmentDTO departmentDTO, Integer id) {
        if (departmentRepository.existsById(id) && companyRepository.existsById(departmentDTO.getCompany_id())){
            Department department = departmentRepository.getOne(id);
            department.setName(departmentDTO.getName());
            department.setCompany(companyRepository.getOne(departmentDTO.getCompany_id()));
            departmentRepository.save(department);
            return ResponseEntity.ok(new Result("Department o'zgartirildi", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli department yoki kompaniya yo'q", false));
    }

    @Override
    public ResponseEntity<Result> delete(Integer id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return ResponseEntity.ok(new Result("Department o'chirildi", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli department yo'q", false));
    }
}
