package uz.pdp.spring2lesson1task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import uz.pdp.spring2lesson1task1.entity.Address;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class WorkerDTO {

    private String name;
    private String phoneNumber;
    private Integer department_id;
    private String street;
    private Integer homeNumber;

}
