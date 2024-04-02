package org.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection = "forex")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forex {
    @Field(value = "Date")
    @JsonProperty("Date")
    private String Date;

    @Field(value = "USD/NTD")
    @JsonProperty("USD/NTD")
    private String USD_NTD;

    @Field(value = "RMB/NTD")
    @JsonProperty("RMB/NTD")
    private String RMB_NTD;

    @Field(value = "EUR/USD")
    @JsonProperty("EUR/USD")
    private String EUR_USD;

    @Field(value = "USD/JPY")
    @JsonProperty("USD/JPY")
    private String USD_JPY;

    @Field(value = "GBP/USD")
    @JsonProperty("GBP/USD")
    private String GBP_USD;

    @Field(value = "AUD/USD")
    @JsonProperty("AUD/USD")
    private String AUD_USD;

    @Field(value = "USD/HKD")
    @JsonProperty("USD/HKD")
    private String USD_HKD;

    @Field(value = "USD/RMB")
    @JsonProperty("USD/RMB")
    private String USD_RMB;

    @Field(value = "USD/ZAR")
    @JsonProperty("USD/ZAR")
    private String USD_ZAR;

    @Field(value = "NZD/USD")
    @JsonProperty("NZD/USD")
    private String NZD_USD;
}
