package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.spring2lesson1task1.entity.Company;
import uz.pdp.spring2lesson1task1.payload.CompanyDTO;
import uz.pdp.spring2lesson1task1.payload.Result;

import java.util.List;

public interface CompanyService {

    ResponseEntity<Result> save(CompanyDTO companyDTO);                   // CREATE

    ResponseEntity<List<Company>> findAll();                                 // READ

    ResponseEntity<Company> findById(Integer id);                            // READ ONE

    ResponseEntity<Result> update(CompanyDTO companyDTO, Integer id);     // UPDATE

    ResponseEntity<Result> delete(Integer id);                                  // DELETE
}
