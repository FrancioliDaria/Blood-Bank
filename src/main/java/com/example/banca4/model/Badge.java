package com.example.banca4.model;

public class Badge {
  private BadgeType badgeType;
  private String description;

  public Badge(BadgeType badgeType, String description) {
    this.badgeType = badgeType;
    this.description = description;
  }

  public BadgeType getBadgeType() {
    return badgeType;
  }

  public void setBadgeType(BadgeType badgeType) {
    this.badgeType = badgeType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
