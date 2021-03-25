package uz.pdp.spring2lesson1task1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private Integer company_id;
}
