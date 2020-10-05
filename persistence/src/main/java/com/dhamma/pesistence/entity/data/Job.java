package com.dhamma.pesistence.entity.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "Jobs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"message", "date"})
        }
)
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String message;
    public LocalDate date;
}
