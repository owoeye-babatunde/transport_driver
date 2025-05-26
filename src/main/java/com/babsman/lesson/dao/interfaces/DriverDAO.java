package com.babsman.lesson.dao.interfaces;

import com.babsman.lesson.model.Driver;

import java.util.List;

public interface DriverDAO {
    void addDriver(Driver driver);

    void updateDriver(Driver driver);
    void deleteDriver(int driverId);
    List<Driver> getAllDrivers();
    Driver getDriverById(int driverId);
    boolean updateDriverPosition(int driverId, boolean increment);
}
