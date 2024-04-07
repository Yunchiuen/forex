package org.example.util;

import org.example.bean.ERROR;

public class Verification {

    private static VerificationDate verificationDate;

    private static VerificationCurrency verificationCurrency;
    private static validateEmpty validateEmpty;
    private Verification() {
    }

    public static ERROR validate(String startDate, String endDate, String currency) {

        if (validateEmpty.validate(startDate, endDate,currency)) {
            return new ERROR("E004", "傳入參數不為空");
        }

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

