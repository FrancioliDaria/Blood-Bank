package com.example.banca4.service;

import com.example.banca4.model.Badge;
import com.example.banca4.model.BadgeType;
import org.springframework.stereotype.Service;

@Service
public class BadgeService {

  public Badge getBadgeByAppointmentCount(int appointmentCount) {
    if (appointmentCount >= 10 && appointmentCount < 20) {
      return new Badge(BadgeType.BRONZE, "Badge 1");
    } else if (appointmentCount >= 20 && appointmentCount < 30) {
      return new Badge(BadgeType.SILVER, "Badge 2");
    } else if (appointmentCount >= 30) {
      return new Badge(BadgeType.GOLD, "Badge 3");
    } else {
      return null;
    }
  }
}


