package com.simplycrud.repo;

import com.simplycrud.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    public List<Vehicle> findAllByYear(int year);

    public Vehicle findVehicleByPlateNumber(String plateNumber);

    public boolean existsVehicleByPlateNumber(String plateNumber);

    public List<Vehicle> findByYearGreaterThan(int year);

    public List<Vehicle> findByYearLessThan(int year);

    public Vehicle findVehicleById(Long id);
}
