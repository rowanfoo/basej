package com.dhamma.pesistence.entity.data;

import com.dhamma.pesistence.utility.JacksonStringToDouble;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@Data
public class Fundamental {

    @Id
    private String code;
    private LocalDate date;
    private Double pe;
    private Double eps;
    @JsonProperty("year_high_date")
    private Double yearHighPrice;
    @JsonProperty("year_low_price")
    private Double yearLowPrice;
    @JsonProperty("annual_dividend_yield")
    private Double annualYied;
    @JsonProperty("market_cap")
    private Long marketcap;
    @JsonProperty("number_of_shares")
    private Long shares;
    @Transient
    private String martketcapAsString;

    @JsonProperty("year_change_in_percentage")
    @JsonDeserialize(using = JacksonStringToDouble.class)
    private Double yearchange;


    @JsonSetter("last_trade_date")
    public void setDateJSON(String mydate) {
        System.out.println("---Fundamental---------setMyDate : " + mydate);


        String newdate = mydate.substring(0, mydate.indexOf("T")).trim();
        System.out.println("NEW DATE------ " + newdate);
        this.date = LocalDate.parse(newdate);

    }

    @JsonSetter("code")
    public void setCodeJSON(String code) {
        System.out.println("----Fundamental--------setCodeJSON : " + code);
        this.code = code + ".AX";

    }

    public String getMartketcapAsString() {
        if (marketcap > 1000000) {
            return (marketcap / 1000000) + "M";
        } else {
            return (marketcap / 1000000000) + "B";
        }

    }

}
