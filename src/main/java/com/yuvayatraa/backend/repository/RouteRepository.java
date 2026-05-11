package com.yuvayatraa.backend.repository;

import com.yuvayatraa.backend.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findBySourceCityAndDestinationCity(
            String sourceCity, String destinationCity
    );
}
