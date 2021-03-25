package uz.pdp.spring2lesson1task1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String corpName;

    @Column(nullable = false)
    private String directorName;

    @OneToOne
    private Address address;

    public Company(String corpName, String directorName, Address address) {
        this.corpName = corpName;
        this.directorName = directorName;
        this.address = address;
    }
}
