package org.example.util;

import org.example.bean.ERROR;

public class Verification {

    private static VerificationDate verificationDate;

    private static VerificationCurrency verificationCurrency;

    private Verification() {
    }

    public static ERROR validate(String startDate, String endDate, String currency) {
        if (verificationDate.validateFormat(startDate, endDate)) {
            return new ERROR("E002", "日期格式錯誤");
        }

        if (verificationDate.validate(startDate, endDate)) {
            return new ERROR("E001", "日期區間不符");
        }

        if (verificationCurrency.validate(currency)) {
            return new ERROR("E003", "查詢幣別有誤");
        }
        return new ERROR();
    }

}

