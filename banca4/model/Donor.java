package com.example.banca4.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Donor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Firstname")
    private String firstname;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Address")
    private String address;

    @Column(name = "BloodType")
    private String bloodType;

    @Column(name = "UserId")
    private Integer userId;

}
