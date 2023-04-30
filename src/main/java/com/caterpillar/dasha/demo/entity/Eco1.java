package com.caterpillar.dasha.demo.entity;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity(name = "eco1")
public class Eco1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column
    String region;
    @Column
    boolean check_text = true;

    public Eco1(String region) {
        this.region = region;
    }
}
