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
    public Appointment(Integer id, Integer donorId, Integer doctorId, Date date, String time) {
        this.id = id;
        this.donorId = donorId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "donorId")
    private Integer donorId;

    @Column(name = "doctorId")
    private Integer doctorId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Time")
    private String time;

    private String address;
    private String doctorFirstName;
    private String doctorLastName;
}
