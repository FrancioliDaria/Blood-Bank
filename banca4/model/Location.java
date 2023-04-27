package com.example.banca4.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name="Location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Address")
    private String address;

}
