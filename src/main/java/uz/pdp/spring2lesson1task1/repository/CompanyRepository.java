package uz.pdp.spring2lesson1task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring2lesson1task1.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByCorpName(String string);
}
