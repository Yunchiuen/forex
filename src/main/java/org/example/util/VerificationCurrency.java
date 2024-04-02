package org.example.util;

public class VerificationCurrency {
    private VerificationCurrency(){}
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
                System.out.println("查詢幣別為:"+currency);
                break;
            default:
                System.out.println("查詢幣別有誤");
                return true;
        }
        return false;
    }
}

