package com.babsman.lesson.dao.interfaces;

import com.babsman.lesson.model.Vehicle;
import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void deleteVehicle(int vehicleId);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(int VehicleId);
    boolean updateVehiclePosition(int VehicleId, boolean increment);
}
