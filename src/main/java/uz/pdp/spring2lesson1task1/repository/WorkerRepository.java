package uz.pdp.spring2lesson1task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring2lesson1task1.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    boolean existsByPhoneNumber(String string);
}
