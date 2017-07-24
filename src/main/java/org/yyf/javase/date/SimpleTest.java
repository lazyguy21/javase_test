package org.yyf.javase.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by tobi on 16-8-2.
 */
public class SimpleTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastOperateDateString = simpleDateFormat.format(new Date());
        System.out.println(lastOperateDateString);
    }

}
