package com.babsman.lesson.dao.impl;

import com.babsman.lesson.config.DatabaseConnection;
import com.babsman.lesson.dao.interfaces.DriverDAO;
import com.babsman.lesson.util.Logger;
import java.sql.*;
import java.util.List;

public class DriverDAOImpl implements DriverDAO {
    private static final Logger logger = new Logger();

    @Override
    public void addDriver(com.babsman.lesson.model.Driver driver) {

    }

    @Override
    public void updateDriver(com.babsman.lesson.model.Driver driver) {

    }

    @Override
    public void deleteDriver(int driverId) {

    }

    @Override
    public List<com.babsman.lesson.model.Driver> getAllDrivers() {
        return List.of();
    }

    @Override
    public com.babsman.lesson.model.Driver getDriverById(int driverId) {
        return null;
    }

    @Override
    public boolean updateDriverPosition(int driverId, boolean increment) {
        return false;
    }
}
