package com.softgroup.common.utility.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeStampUtil {

    public static Timestamp currentForSql() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    public static long current() {
        return ZonedDateTime
                .now(ZoneId.systemDefault())
                .toEpochSecond();
    }

    public static boolean isExpiredTimeBeforeCurrentTime(long expiredTimestamp) {
        Instant currentInstant = Instant.ofEpochSecond( current() );
        return Instant.ofEpochSecond( expiredTimestamp ).isBefore( currentInstant );
    }

    public static ExpiredTimeStampBuilder expiredBuilder(long currentTimestamp) {
        return new ExpiredTimeStampBuilder(currentTimestamp);
    }

    public static class ExpiredTimeStampBuilder {

        private ZonedDateTime zonedDateTime;

        public ExpiredTimeStampBuilder(long timestamp) {
            zonedDateTime = ZonedDateTime.ofInstant(
                                            Instant.ofEpochSecond(timestamp),
                                            ZoneId.systemDefault()
                                          );
        }

        public ExpiredTimeStampBuilder addYears(long years) {
            zonedDateTime = zonedDateTime.plusYears(years);
            return this;
        }

        public ExpiredTimeStampBuilder addMonths(long months) {
            zonedDateTime = zonedDateTime.plusMonths(months);
            return this;
        }

        public ExpiredTimeStampBuilder addWeeks(long weeks) {
            zonedDateTime = zonedDateTime.plusWeeks(weeks);
            return this;
        }

        public ExpiredTimeStampBuilder addDays(long days) {
            zonedDateTime = zonedDateTime.plusDays(days);
            return this;
        }

        public ExpiredTimeStampBuilder addHours(long hours) {
            zonedDateTime = zonedDateTime.plusHours(hours);
            return this;
        }

        public ExpiredTimeStampBuilder addMinutes(long minutes) {
            zonedDateTime = zonedDateTime.plusMinutes(minutes);
            return this;
        }

        public ExpiredTimeStampBuilder addSeconds(long seconds) {
            zonedDateTime = zonedDateTime.plusSeconds(seconds);
            return this;
        }

        public long build() {
            return zonedDateTime.toEpochSecond();
        }
    }
}