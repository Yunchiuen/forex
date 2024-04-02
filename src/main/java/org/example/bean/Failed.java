package org.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Failed implements Result {

    private R Failed;

    public Failed(String code, String message) {
        this.Failed = new R(new ERROR(code , message));
    }

    public void setFailed(String code, String message) {
        this.Failed = new R(new ERROR(code , message));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class R {
        private ERROR error;
    }
}
