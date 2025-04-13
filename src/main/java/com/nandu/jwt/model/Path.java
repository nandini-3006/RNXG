package com.nandu.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Path {

    @Id
    @GeneratedValue
    private Long id;

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private String pathPoints;
}
