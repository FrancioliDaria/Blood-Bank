package com.example.banca4.service;
import com.example.banca4.model.Donor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class WallOfFameService {
  private List<Donor> topDonors;

  public WallOfFameService() {
    this.topDonors = new ArrayList<>();
  }

  public void updateWallOfFame(List<Donor> donors) {
   // Collections.sort(donors, Comparator.comparingInt(Donor::getAppointmentCount).reversed());
    topDonors = donors.subList(0, Math.min(3, donors.size()));
  }

  public List<Donor> getTopDonors() {
    return topDonors;
  }
}
