package com.my.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {
    SUCCESS("0000", "成功"),

    INTERVAL_FAILED("E001", "日期區間不符"),

    FORMAT_FAILED("E002", "日期格式錯誤"),

    CURRENCY_FAILED("E003", "查詢幣別有誤"),

    VALUES_NOTNULL("E004", "傳入參數不為空");

    private String code;
    private String msg;
}
