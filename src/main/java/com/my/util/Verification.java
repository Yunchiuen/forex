package com.my.util;

import com.my.bean.Error;
import com.my.bean.Failed;

public class Verification {

    private static VerificationDate verificationDate;

    private static VerificationCurrency verificationCurrency;

    private static validateEmpty validateEmpty;

    private Verification() {
    }

    public static Failed validate(String startDate, String endDate, String currency) {

        if (validateEmpty.validate(startDate, endDate,currency)) {
            return new Failed(Error.VALUES_NOTNULL);
        }

        if (verificationDate.validateFormat(startDate, endDate)) {
            return new Failed(Error.FORMAT_FAILED);
        }

        if (verificationDate.validate(startDate, endDate)) {
            return new Failed(Error.INTERVAL_FAILED);
        }

        if (verificationCurrency.validate(currency)) {
            return new Failed(Error.CURRENCY_FAILED);
        }
        return new Failed(Error.SUCCESS);
    }

}

