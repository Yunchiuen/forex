package com.my.util;

import java.util.logging.Logger;

public class VerificationCurrency {
    private static final Logger LOGGER = Logger.getLogger(VerificationCurrency.class.getName());

    private VerificationCurrency() {
    }

    public static boolean validate(String currency) {
        switch (currency) {
            case "USD/NTD":
            case "RMB/NTD":
            case "EUR/USD":
            case "USD/JPY":
            case "GBP/USD":
            case "AUD/USD":
            case "USD/HKD":
            case "USD/RMB":
            case "USD/ZAR":
            case "NZD/USD":
                LOGGER.info("查詢幣別為:" + currency);
                break;
            default:
                LOGGER.severe("查詢幣別有誤");
                return true;
        }
        return false;
    }
}

