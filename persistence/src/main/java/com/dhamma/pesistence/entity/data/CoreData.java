package com.dhamma.pesistence.entity.data;

import lombok.Getter;
import lombok.Setter;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DoubleNum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;

@Entity
@Getter
@Setter


public class CoreData {
    public static String CACHE_NAME = "CoreData";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @QuerySqlField(index = true)
    public String code;
    //@QuerySqlField(index = true, descending = true)
    @QuerySqlField(index = true)
    public LocalDate date;
    public Double open;
    public Double high;
    public Double low;
    @QuerySqlField
    public Long volume;
    public Double changes;
    @QuerySqlField
    public Double close;
    @QuerySqlField
    Double changepercent;
    String previousclose;


    public Double getChangepercent() {
        DecimalFormat df = new DecimalFormat("#.##");
        if (changepercent == null) return 0.00;
        return Double.parseDouble(df.format(changepercent));
    }

    public String getIgniteid() {
        return code + date;
    }

    @Override
    public String toString() {
        return "CoreData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", changes=" + changes +
                ", changepercent=" + changepercent +
                ", previousclose='" + previousclose + '\'' +
                '}';
    }

    public String getVolAsString() {
        if (volume > 1000000000) {
            return (volume / 1000000000) + "B";
        } else {
            return (volume / 1000000) + "M";
        }

    }


    public BaseBar toBar() {
        return new BaseBar(date.atStartOfDay(ZoneId.of("Australia/Sydney")), this.open, this.high, this.low, this.close, this.volume.doubleValue(), DoubleNum::valueOf);
    }
}
