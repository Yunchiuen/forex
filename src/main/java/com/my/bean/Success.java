package com.my.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Success<T> implements Result {
    private Status error;
    private T currency;
    public Success(Error error , T currency) {
        this.error = new Status(error.getCode() ,error.getMsg());
        this.currency = currency;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Status {
        private String code;
        private String msg;
    }
}
