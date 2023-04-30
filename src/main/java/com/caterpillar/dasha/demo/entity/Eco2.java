package com.caterpillar.dasha.demo.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity(name = "eco2")
public class Eco2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String level;

    @Column
    boolean check_text = true;

    public Eco2(String level) {
        this.level = level;
    }

}
