package com.softgroup.common.utility;

import com.softgroup.common.utility.time.TimeStampUtil;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;

public class TimeStampUtilTest {

    @Test
    public void test() {
        long created = TimeStampUtil.current();

        long expired = TimeStampUtil.expiredBuilder(created)
                .addDays(2).addYears(5).addMonths(9).build();

        System.out.println(ZonedDateTime.ofInstant( Instant.ofEpochSecond(expired), ZoneId.systemDefault()));
        //System.out.println( ZonedDateTime.now(ZoneId.systemDefault()).plusYears(2) );




        //System.out.println(LocalDateTime.ofEpochSecond(expired, 0, ZoneOffset.UTC));
    }

    @Test
    public void testCurrentSql() {
        Timestamp ts = TimeStampUtil.currentForSql();
        System.out.println( ts );
    }
}
