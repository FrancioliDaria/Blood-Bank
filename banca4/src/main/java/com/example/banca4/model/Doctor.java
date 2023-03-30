package com.example.banca4.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="Doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "LocationId")
    private Integer locationId;

    @Column(name = "Program")
    private Integer program;

    @Column(name = "UserId")
    private Integer userId;

}
