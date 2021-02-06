package com.dhamma.pesistence.entity.data;

//import com.dhamma.pesistence.entity.data.PeriodType;

import com.dhamma.pesistence.entity.data.type.DurationType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String userid;
    public String code;
    public LocalDate date;
    public String type; // idea , financial ,
    public String text;
    public String reject;
//    @Enumerated(EnumType.STRING)
//    @Type(type = "pgsql_enum")
//    public PeriodType period;

    @Column(columnDefinition = "boolean default false")
    public Boolean isReject = false;
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    public DurationType period;


}
