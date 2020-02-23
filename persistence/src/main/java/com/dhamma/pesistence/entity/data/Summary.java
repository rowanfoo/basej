package com.dhamma.pesistence.entity.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rsi;
    public LocalDate date;
    private Integer fourdown;
    private Integer down;
    private Integer up;

    @Transient
    private Double ratiodown;


    public Double getRatiodown() {
        return down.doubleValue() / (down.doubleValue() + up.doubleValue());
    }

}
