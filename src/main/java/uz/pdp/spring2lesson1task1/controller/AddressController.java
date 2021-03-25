package uz.pdp.spring2lesson1task1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task1.entity.Address;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.service.AddressService;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping()
    public ResponseEntity<Result> addAddress(@RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping()
    public ResponseEntity<List<Address>> getAddress(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getOneAddress(@PathVariable Integer id){
        return addressService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAddress(@PathVariable Integer id, @RequestBody Address address){
        return addressService.update(address, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteAddress(@PathVariable Integer id){
        return addressService.delete(id);
    }
}
