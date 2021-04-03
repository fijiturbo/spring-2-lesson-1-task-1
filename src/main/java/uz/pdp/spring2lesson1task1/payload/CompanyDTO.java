package uz.pdp.spring2lesson1task1.payload;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class CompanyDTO {
    private String corpName;
    private String directorName;
    private String street;
    private Integer homeNumber;
}
