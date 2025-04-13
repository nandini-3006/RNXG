package com.nandu.jwt.controller;

import com.nandu.jwt.dto.PathRequest;
import com.nandu.jwt.model.Path;
import com.nandu.jwt.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/path")
public class PathController {

    @Autowired
    private PathService pathService;

    @PostMapping
    public Path calculateAndSavePath(@RequestBody PathRequest request) {
        return pathService.calculateAndSavePath(
                request.getStartX(),
                request.getStartY(),
                request.getEndX(),
                request.getEndY()
        );
    }

    @GetMapping
    public List<Path> getAllPaths() {
        return pathService.getAllPaths();
    }
}
