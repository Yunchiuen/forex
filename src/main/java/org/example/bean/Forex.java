package org.example.bean;

import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection = "forex")
public class Forex {
    @Field(value = "Date")
    private String Date;

    @Field(value = "USD/NTD")
    private String USD_NTD;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getUSD_NTD() {
        return USD_NTD;
    }

    public void setUSD_NTD(String USD_NTD) {
        this.USD_NTD = USD_NTD;
    }

    @Override
    public String toString() {
        return "Forex{" +
                "Date='" + Date + '\'' +
                ", USD_NTD='" + USD_NTD + '\'' +
                '}';
    }
}
