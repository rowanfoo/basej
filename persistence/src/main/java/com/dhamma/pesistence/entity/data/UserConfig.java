package com.dhamma.pesistence.entity.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)


public class UserConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userid;
    LocalDate date;
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    public IndicatorType type;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    String algo;
    String text;
    String description;

    @JsonIgnore
    public String getAlgoValue(String type) {
        return new Gson().fromJson(algo, JsonObject.class).get(type).getAsString();

    }

    @JsonIgnore
    public String getAlgoValue() {
        return getAlgoValue("value");
    }


}
