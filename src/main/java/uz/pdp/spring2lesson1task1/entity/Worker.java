package uz.pdp.spring2lesson1task1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne
    private Address address;

    @OneToOne
    private Department department;

    public Worker(String name, String phoneNumber, Address address, Department department) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.department = department;
    }
}
