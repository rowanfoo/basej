package com.dhamma.pesistence.entity.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter

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
    @Column(nullable = false)
    public Boolean isReject;

}
