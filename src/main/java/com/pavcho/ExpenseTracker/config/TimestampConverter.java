package com.pavcho.ExpenseTracker.config;

import com.pavcho.ExpenseTracker.entity.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimestampConverter {

  public static LocalDateTime convertTimestampToLocalDateTime(Long timestamp, User user) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of(user.getZoneId()));
  }
}
