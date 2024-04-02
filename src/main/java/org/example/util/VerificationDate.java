package org.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VerificationDate {
    private VerificationDate() {
    }

    public static boolean validate(String startDate, String endDate) {
        //今天
        LocalDate currentDate = LocalDate.now();
        //今天減一年
        LocalDate previousYear = currentDate.minusYears(1);
        //今天減一天
        LocalDate previousDay = currentDate.minusDays(1);

        LocalDate date1 = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        LocalDate date2 = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        if (date1.isBefore(previousYear) || date1.isAfter(previousDay)) {
            System.out.println("第一個日期必須介於去年到昨天之間");
            return true;
        }

        if (date2.isBefore(previousYear) || date2.isAfter(previousDay)) {
            System.out.println("第二個日期必須介於去年到昨天之間");
            return true;
        }
        return false;
    }

    public static boolean validateFormat(String startDate, String endDate) {
        try {
            LocalDate date1 = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            LocalDate date2 = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        } catch (DateTimeParseException e) {
            System.out.println("日期格式錯誤");
            return true;
        }
        return false;
    }
}
