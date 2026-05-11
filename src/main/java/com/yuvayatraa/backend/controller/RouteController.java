
package com.yuvayatraa.backend.controller;

import com.yuvayatraa.backend.dto.ApiResponse;
import com.yuvayatraa.backend.dto.RouteRequest;
import com.yuvayatraa.backend.service.RouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RouteController {

    private final RouteService routeService;

    @GetMapping
    public ResponseEntity<?> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchRoutes(
            @RequestParam String from,
            @RequestParam String to) {
        return ResponseEntity.ok(routeService.searchRoutes(from, to));
    }

    @PostMapping("/admin/add")
    public ResponseEntity<ApiResponse> addRoute(
            @Valid @RequestBody RouteRequest request) {
        return ResponseEntity.ok(routeService.addRoute(request));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<ApiResponse> deleteRoute(@PathVariable Long id) {
        return ResponseEntity.ok(routeService.deleteRoute(id));
    }
}