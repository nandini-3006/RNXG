package com.nandu.jwt.dto;

import lombok.Data;

@Data
public class PathRequest {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
}
