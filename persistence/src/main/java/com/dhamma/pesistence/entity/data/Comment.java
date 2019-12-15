package com.dhamma.pesistence.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data

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
    @Column(columnDefinition = "boolean default false")
    public Boolean isReject = false;

}
