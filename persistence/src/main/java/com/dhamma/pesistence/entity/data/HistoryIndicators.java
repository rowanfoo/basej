package com.dhamma.pesistence.entity.data;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "History_Indicators",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code", "date", "type", "userid"})
        }
)
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)

public class HistoryIndicators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String code;
    public LocalDate date;
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    public IndicatorType type;
    public String message;
    public String userid;


}
