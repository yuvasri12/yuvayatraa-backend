package com.yuvayatraa.backend.service;

import com.yuvayatraa.backend.dto.ApiResponse;
import com.yuvayatraa.backend.dto.BusRequest;
import com.yuvayatraa.backend.entity.Bus;
import com.yuvayatraa.backend.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusService {

    private final BusRepository busRepository;

    public ApiResponse addBus(BusRequest request) {
        if (busRepository.existsByBusNumber(request.getBusNumber())) {
            throw new RuntimeException("Bus number already exists!");
        }

        Bus bus = Bus.builder()
                .busName(request.getBusName())
                .busNumber(request.getBusNumber())
                .busType(request.getBusType())
                .totalCapacity(request.getTotalCapacity())
                .wifi(request.getWifi())
                .charging(request.getCharging())
                .water(request.getWater())
                .active(true)
                .build();

        busRepository.save(bus);
        return new ApiResponse(true, "Bus added successfully!", bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findByActive(true);
    }

    public ApiResponse deleteBus(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found!"));
        bus.setActive(false);
        busRepository.save(bus);
        return new ApiResponse(true, "Bus deleted successfully!", null);
    }
}