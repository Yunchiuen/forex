package org.example.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class validateEmpty {
    public static boolean validate(String startDate, String endDate, String currency) {

        if (startDate == null) {
            System.out.println("startDate不為空");
            return true;
        }

        if (endDate == null) {
            System.out.println("endDate不為空");
            return true;
        }

        if (currency == null) {
            System.out.println("currency不為空");
            return true;
        }

        return false;
    }
}
