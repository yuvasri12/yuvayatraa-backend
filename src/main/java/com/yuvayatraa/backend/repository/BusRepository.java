package com.yuvayatraa.backend.repository;

import com.yuvayatraa.backend.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByActive(Boolean active);
    Boolean existsByBusNumber(String busNumber);
}