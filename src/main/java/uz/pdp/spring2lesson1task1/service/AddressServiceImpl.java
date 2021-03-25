package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;
import uz.pdp.spring2lesson1task1.entity.Address;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.repository.AddressRepository;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public ResponseEntity<Result> save(Address address) {
        if (addressRepository.existsByStreet(address.getStreet()) && addressRepository.existsByHomeNumber(address.getHomeNumber())) {
            return ResponseEntity.ok(new Result("Bunday adress bor. id=" + addressRepository.getAddressByStreetAndHomeNumber(
                    address.getStreet(), address.getHomeNumber()), false));
        }
        addressRepository.save(address);
        return ResponseEntity.ok(new Result("Address qo'shildi", true));
    }

    @Override
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressRepository.findAll());
    }

    @Override
    public ResponseEntity<Address> findById(Integer id) {
        if (addressRepository.existsById(id)){
            return ResponseEntity.ok(addressRepository.getOne(id));
        }
        return ResponseEntity.ok(new Address());
    }

    @Override
    public ResponseEntity<Result> update(Address address, Integer id) {
        if (addressRepository.existsById(id)){
            Address outAddress = addressRepository.getOne(id);
            outAddress.setHomeNumber(address.getHomeNumber());
            outAddress.setStreet(address.getStreet());
            addressRepository.save(outAddress);
            return ResponseEntity.ok(new Result("Address o'zgartirildi", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli address yo'q", false));
    }

    @Override
    public ResponseEntity<Result> delete(Integer id) {
        if (addressRepository.existsById(id)){
            addressRepository.deleteById(id);
            return ResponseEntity.ok(new Result("Address o'chirildi", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli address yo'q", false));
    }
}
