package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.spring2lesson1task1.entity.Address;
import uz.pdp.spring2lesson1task1.payload.Result;

import java.util.List;

public interface AddressService {

    ResponseEntity<Result> save(Address address);                   // CREATE

    ResponseEntity<List<Address>> findAll();                                 // READ

    ResponseEntity<Address> findById(Integer id);                            // READ ONE

    ResponseEntity<Result> update(Address address, Integer id);     // UPDATE

    ResponseEntity<Result> delete(Integer id);                                  // DELETE
}
