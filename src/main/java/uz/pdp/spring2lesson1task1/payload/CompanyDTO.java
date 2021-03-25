package uz.pdp.spring2lesson1task1.payload;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTO {
    private String corpName;
    private String directorName;
    private Integer address_id;
}
