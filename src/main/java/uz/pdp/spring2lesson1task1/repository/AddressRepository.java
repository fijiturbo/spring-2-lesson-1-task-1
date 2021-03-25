package uz.pdp.spring2lesson1task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring2lesson1task1.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    boolean existsByStreet(String string);
    boolean existsByHomeNumber(Integer integer);
    Address getAddressByStreetAndHomeNumber(String string, Integer integer);
}
