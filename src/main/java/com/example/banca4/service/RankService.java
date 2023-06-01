package com.example.banca4.service;
import com.example.banca4.model.Donor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//Gestionează clasamentul (rank) donatorilor în funcție de numărul de programări (appointments) pe care le-au realizat.
// De asemenea, aceasta oferă metoda pentru a obține primii donatori din clasament (top donori pentru wall of fame).

class RankService {
  private List<Donor> donors;

  public RankService() {
    this.donors = new ArrayList<>();
  }

  public void addAppointment(int donorId) {
    for (Donor donor : donors) {
      if (donor.getId() == donorId) {
        //donor.appointmentCount++;
        break;
      }
    }
  }

  public List<Donor> getTopDonors(int count) {
   // Collections.sort(donors, Comparator.comparingInt(Donor::getAppointmentCount).reversed());
    return donors.subList(0, Math.min(count, donors.size()));
  }
}
