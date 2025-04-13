package com.nandu.jwt.service;

import com.nandu.jwt.model.Path;
import com.nandu.jwt.repository.PathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@Service
public class PathService {

    @Autowired
    private PathRepository pathRepository;

    public Path calculateAndSavePath(int startX, int startY, int endX, int endY) {
        List<Point> points = generatePath(startX, startY, endX, endY);

        StringBuilder pathString = new StringBuilder();
        for (Point point : points) {
            pathString.append("(").append(point.x).append(",").append(point.y).append(") ");
        }

        Path path = new Path();
        path.setStartX(startX);
        path.setStartY(startY);
        path.setEndX(endX);
        path.setEndY(endY);
        path.setPathPoints(pathString.toString().trim());

        return pathRepository.save(path);
    }

    public List<Path> getAllPaths() {
        return pathRepository.findAll();
    }

    private List<Point> generatePath(int i, int j, int x, int y) {
        List<Point> path = new ArrayList<>();

        int p = i;
        int q = j;

        int dx = Integer.compare(x, i);
        int dy = Integer.compare(y, j);

        path.add(new Point(p, q));

        while (p != x || q != y) {
            if (p != x) p += dx;
            if (q != y) q += dy;
            path.add(new Point(p, q));
        }

        return path;
    }
}
