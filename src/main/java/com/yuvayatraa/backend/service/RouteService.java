
package com.yuvayatraa.backend.service;

import com.yuvayatraa.backend.dto.ApiResponse;
import com.yuvayatraa.backend.dto.RouteRequest;
import com.yuvayatraa.backend.entity.Bus;
import com.yuvayatraa.backend.entity.Route;
import com.yuvayatraa.backend.repository.BusRepository;
import com.yuvayatraa.backend.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final BusRepository busRepository;

    public ApiResponse addRoute(RouteRequest request) {
        Bus bus = null;
        if (request.getBusId() != null) {
            bus = busRepository.findById(request.getBusId())
                    .orElseThrow(() -> new RuntimeException("Bus not found!"));
        }

        Route route = Route.builder()
                .sourceCity(request.getSourceCity())
                .destinationCity(request.getDestinationCity())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .baseFare(request.getBaseFare())
                .daily(request.getDaily())
                .monFri(request.getMonFri())
                .weekends(request.getWeekends())
                .bus(bus)
                .build();

        routeRepository.save(route);
        return new ApiResponse(true, "Route created successfully!", route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Route> searchRoutes(String from, String to) {
        return routeRepository.findBySourceCityAndDestinationCity(from, to);
    }

    public ApiResponse deleteRoute(Long id) {
        routeRepository.deleteById(id);
        return new ApiResponse(true, "Route deleted successfully!", null);
    }
}