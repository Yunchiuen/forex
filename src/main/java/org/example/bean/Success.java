package org.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Success<T> implements Result {

    private Bean<T> Success;

    public Success(T currency) {
        this("0000", "成功", currency);
    }

    public Success(String code, String message, T currency) {
        this.Success = new Bean(new ERROR(code, message), currency);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Bean<T> {
        private ERROR error;
        private T currency;
    }
}
