package com.dhamma.pesistence.entity.data;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
public class ImageChart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public Long refid;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String image;

}
