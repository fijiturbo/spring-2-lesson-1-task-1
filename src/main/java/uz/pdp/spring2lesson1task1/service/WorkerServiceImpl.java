package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.spring2lesson1task1.entity.Address;
import uz.pdp.spring2lesson1task1.entity.Worker;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.payload.WorkerDTO;
import uz.pdp.spring2lesson1task1.repository.AddressRepository;
import uz.pdp.spring2lesson1task1.repository.DepartmentRepository;
import uz.pdp.spring2lesson1task1.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final DepartmentRepository departmentRepository;
    private final AddressRepository addressRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, DepartmentRepository departmentRepository, AddressRepository addressRepository) {
        this.workerRepository = workerRepository;
        this.departmentRepository = departmentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public ResponseEntity<Result> save(WorkerDTO workerDTO) {
        if (workerRepository.existsByPhoneNumber(workerDTO.getPhoneNumber())) {
            return ResponseEntity.ok(new Result("Bunday phonenumberli worker bor.", false));
        } else if (departmentRepository.existsById(workerDTO.getDepartment_id())) {
            Address address = new Address();
            address.setHomeNumber(workerDTO.getHomeNumber());
            address.setStreet(workerDTO.getStreet());
            Address savedAddress = addressRepository.save(address);
            Worker worker = new Worker(workerDTO.getName(), workerDTO.getPhoneNumber(),
                    savedAddress, departmentRepository.getOne(workerDTO.getDepartment_id()));
            workerRepository.save(worker);
            return ResponseEntity.ok(new Result("Worker qo'shildi", true));

        } else {
            return ResponseEntity.ok(new Result("Bunday idli departament yo'q", false));

        }
    }

    @Override
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @Override
    public ResponseEntity<Worker> findById(Integer id) {
        if (workerRepository.existsById(id)) {
            return ResponseEntity.ok(workerRepository.getOne(id));
        }
        return ResponseEntity.ok(new Worker());
    }

    @Override
    public ResponseEntity<Result> update(WorkerDTO workerDTO, Integer id) {
        if (workerRepository.existsById(id)) {
            if (departmentRepository.existsById(workerDTO.getDepartment_id())) {
                Worker worker = workerRepository.getOne(id);
                worker.setName(workerDTO.getName());
                worker.setPhoneNumber(workerDTO.getPhoneNumber());

                Address address = new Address();
                address.setHomeNumber(workerDTO.getHomeNumber());
                address.setStreet(workerDTO.getStreet());
                Address savedAddress = addressRepository.save(address);

                worker.setAddress(savedAddress);
                worker.setDepartment(departmentRepository.getOne(workerDTO.getDepartment_id()));
                workerRepository.save(worker);
                return ResponseEntity.ok(new Result("Worker o'zgartirildi", true));
            } else {
                return ResponseEntity.ok(new Result("Bunday idli department yo'q", false));
            }
        } else {
            return ResponseEntity.ok(new Result("Bunday idli worker yo'q", false));
        }
    }

    @Override
    public ResponseEntity<Result> delete(Integer id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return ResponseEntity.ok(new Result("Worker o'chirildi", true));
        }
        return ResponseEntity.ok(new Result("bunday idli Worker yo'q", false));

    }
}
