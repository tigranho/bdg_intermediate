package com.bdg.ams.util;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Convert {

    public static LocalDate convertToLocalDateViaInstant(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public static ZonedDateTime getZonedDateTime(String charSequence) throws ParseException {
        java.util.Date date = DateUtils.parseDate(charSequence,
                "MM/dd/yyy", "MM/d/yyyy", "M/dd/yyyy", "M/d/yyyy");

        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault());
    }
}
