package com.my.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Failed implements Result {
    private Status error;

    public Failed(Error error) {
        this.error = new Status(error.getCode() ,error.getMsg());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Status {
        private String code;
        private String msg;
    }
}
