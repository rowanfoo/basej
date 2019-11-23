package com.dhamma.pesistence.entity.data;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity
@Getter
@Setter
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public java.sql.Date date;
    public String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String algo;


}
