package com.my.util;

import java.util.logging.Logger;

public class validateEmpty {
    private static final Logger LOGGER = Logger.getLogger(validateEmpty.class.getName());
    public static boolean validate(String startDate, String endDate, String currency) {

        if (startDate == null) {
            LOGGER.severe("startDate不為空");
            return true;
        }

        if (endDate == null) {
            LOGGER.severe("endDate不為空");
            return true;
        }

        if (currency == null) {
            LOGGER.severe("currency不為空");
            return true;
        }

        return false;
    }
}
