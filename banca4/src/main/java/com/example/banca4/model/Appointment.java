package com.example.banca4.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name="Appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "doctorId")
    private Integer doctorId;

    @Column(name = "Data")
    private Date data;

    @Column(name = "Time")
    private String time;

}
