package com.pavcho.ExpenseTracker.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimestampConverter {

  public static LocalDateTime convertTimestampToLocalDateTime(Long timestamp, String zoneId) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of(zoneId));
  }
}
