package uz.pdp.spring2lesson1task1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task1.entity.Company;
import uz.pdp.spring2lesson1task1.payload.CompanyDTO;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.service.CompanyService;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping()
    public ResponseEntity<Result> addCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.save(companyDTO);
    }

    @GetMapping()
    public ResponseEntity<List<Company>> getCompany(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getOne(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAddress(@PathVariable Integer id, @RequestBody CompanyDTO companyDTO){
        return companyService.update(companyDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteAddress(@PathVariable Integer id){
        return companyService.delete(id);
    }
}
/*
*  @PostMapping()
    public ResponseEntity<Result> add(){
        return .save();
    }

    @GetMapping()
    public ResponseEntity<List<>> get(){
        return .findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<> getOne(@PathVariable Integer id){
        return .findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAddress(@PathVariable Integer id, @RequestBody ){
        return .update(, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteAddress(@PathVariable Integer id){
        return .delete(id);
    }
* */