package org.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class ERROR {
    private String code;
    private String message;
    public ERROR() {
        this.code = "0000";
        this.message = "成功";
    }
}
