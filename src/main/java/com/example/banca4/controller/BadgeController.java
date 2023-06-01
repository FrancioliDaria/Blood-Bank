package com.example.banca4.controller;

import com.example.banca4.model.Badge;
import com.example.banca4.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/badge")
public class BadgeController {

  private final BadgeService badgeService;

  @Autowired
  public BadgeController(BadgeService badgeService) {
    this.badgeService = badgeService;
  }

  @GetMapping("/{appointmentCount}")
  public ResponseEntity<Badge> getBadgeByAppointmentCount(@PathVariable int appointmentCount) {
    Badge badge = badgeService.getBadgeByAppointmentCount(appointmentCount);
    if (badge != null) {
      return ResponseEntity.ok(badge);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
