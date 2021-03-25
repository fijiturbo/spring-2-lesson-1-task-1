package uz.pdp.spring2lesson1task1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring2lesson1task1.entity.Worker;
import uz.pdp.spring2lesson1task1.payload.Result;
import uz.pdp.spring2lesson1task1.payload.WorkerDTO;
import uz.pdp.spring2lesson1task1.service.WorkerService;
import java.util.List;

@RestController
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping()
    public ResponseEntity<Result> add(@RequestBody WorkerDTO workerDTO){
        return workerService.save(workerDTO);
    }

    @GetMapping()
    public ResponseEntity<List<Worker>> get(){
        return workerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getOne(@PathVariable Integer id){
        return workerService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAddress(@PathVariable Integer id, @RequestBody WorkerDTO workerDTO){
        return workerService.update(workerDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteAddress(@PathVariable Integer id){
        return workerService.delete(id);
    }
}
