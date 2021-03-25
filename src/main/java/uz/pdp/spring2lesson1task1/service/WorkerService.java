package uz.pdp.spring2lesson1task1.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.spring2lesson1task1.entity.Worker;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.payload.WorkerDTO;

import java.util.List;

public interface WorkerService {

    ResponseEntity<Result> save(WorkerDTO workerDTO);                   // CREATE

    ResponseEntity<List<Worker>> findAll();                                 // READ

    ResponseEntity<Worker> findById(Integer id);                            // READ ONE

    ResponseEntity<Result> update(WorkerDTO workerDTO, Integer id);     // UPDATE

    ResponseEntity<Result> delete(Integer id);                                  // DELETE
}
