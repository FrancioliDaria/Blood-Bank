package com.example.banca4.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="WallOfFameEntry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WallOfFameEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "position")
  private Integer position;
}
