package com.yuvayatraa.backend.controller;

import com.yuvayatraa.backend.dto.ApiResponse;
import com.yuvayatraa.backend.dto.BusRequest;
import com.yuvayatraa.backend.service.BusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BusController {

    private final BusService busService;

    @GetMapping
    public ResponseEntity<?> getAllBuses() {
        return ResponseEntity.ok(busService.getAllBuses());
    }

    @PostMapping("/admin/add")
    public ResponseEntity<ApiResponse> addBus(
            @Valid @RequestBody BusRequest request) {
        return ResponseEntity.ok(busService.addBus(request));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<ApiResponse> deleteBus(@PathVariable Long id) {
        return ResponseEntity.ok(busService.deleteBus(id));
    }
}
