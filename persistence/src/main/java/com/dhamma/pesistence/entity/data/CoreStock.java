package com.dhamma.pesistence.entity.data;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class CoreStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @QuerySqlField(index = true)
    public String code;
    public java.sql.Date date;
    @QuerySqlField
    public String name;
    public String descp;
    public Long shares;
    @QuerySqlField
    public Long marketcap;
    public String consequtivelow;
    @QuerySqlField
    public String category;
    @QuerySqlField
    public String subcategory;
    @QuerySqlField
    public String top;
    public String notes1;
    public String notes2;
    public String reason;
    public String moat;
    public String fundnotes;
    public Double buytrigger;
    public String wishlist;
    public String trend;
    public Double alertprice;
    public Double normandyprice;
    public String normandynotes;
    public String fydate;
    public String technicalnotes;
    public String montlynotes;
    public String weeklynotes;
    public String dailynotes;
    public Double stoploss;
    public String stoplossnotes;
    public String whenbuy;
    public Double whenbuyprice;
    public String easychange;
    public Double keysupportprice;
    public String keysupportpricenotes;
    public String defendkeynotes;
    public Double defendkeyprice;
    public String nope;
    public String news;
    public String chart;
    public String stagegrowth;
    public String research;
    public String researchcat;
    public String onenotes;
    public String aindex;
    public String delisted;
    public Double yearhigh;
    public Double pe;
    public Double eps;
    public Double yearlow;
    public Double dividend;
    public Long dailyvol;
    public Double yearchangepercentage;
    public String tolook;
    public String tags;

//  public String getMarketcapString(){
//    return  NumberFormat.getIntegerInstance().format(marketcap);
//  }


    public CoreStock() {
    }


}
