package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task1.entity.Company;
import uz.pdp.spring2lesson1task1.payload.CompanyDTO;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.repository.AddressRepository;
import uz.pdp.spring2lesson1task1.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public ResponseEntity<Result> save(CompanyDTO companyDTO) {
        if (companyRepository.existsByCorpName(companyDTO.getCorpName())) {
            return ResponseEntity.ok(new Result("Bunday nomli kompaniya bor.", false));
        } else if (addressRepository.existsById(companyDTO.getAddress_id())) {
            Company company = new Company(companyDTO.getCorpName(), companyDTO.getDirectorName(),
                    addressRepository.getOne(companyDTO.getAddress_id()));
            companyRepository.save(company);
            return ResponseEntity.ok(new Result("Kompaniya qo'shildi", true));
        } else {
            return ResponseEntity.ok(new Result("Bunday idli adress yoq'.", false));
        }
    }

    @Override
    public ResponseEntity<List<Company>> findAll() {
        return ResponseEntity.ok(companyRepository.findAll());
    }

    @Override
    public ResponseEntity<Company> findById(Integer id) {
        if (companyRepository.existsById(id)) {
            return ResponseEntity.ok(companyRepository.getOne(id));
        }
        return ResponseEntity.ok(new Company());
    }

    @Override
    public ResponseEntity<Result> update(CompanyDTO companyDTO, Integer id) {
        if (companyRepository.existsById(id)) {
            Company company = companyRepository.getOne(id);
            company.setCorpName(company.getCorpName());
            company.setDirectorName(company.getDirectorName());
            company.setAddress(addressRepository.getOne(companyDTO.getAddress_id()));
            companyRepository.save(company);
            return ResponseEntity.ok(new Result("Kompaniya qo'shildi.", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli kompaniya yoq.", false));
    }

    @Override
    public ResponseEntity<Result> delete(Integer id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return ResponseEntity.ok(new Result("Kompaniya o'chirildi.", true));
        }
        return ResponseEntity.ok(new Result("Bunday idli address yo'q.", false));
    }
}
