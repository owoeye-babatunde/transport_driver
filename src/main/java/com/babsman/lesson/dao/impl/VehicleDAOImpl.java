package com.babsman.lesson.dao.impl;

import com.babsman.lesson.config.DatabaseConnection;
import com.babsman.lesson.dao.interfaces.VehicleDAO;
import com.babsman.lesson.model.Vehicle;
import com.babsman.lesson.util.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {

    private static final Logger logger = new Logger();

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (color, fuelType, manufacturer, moving) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, vehicle.getColor());
            stmt.setString(2, vehicle.getFuelType());
            stmt.setString(3, vehicle.getManufacturer());
            stmt.setBoolean(4, vehicle.isMoving());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating book failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vehicle.setVehicleId(generatedKeys.getInt(1));
                    logger.log("Vehicle added: " + vehicle.getManufacturer());
                } else {
                    throw new SQLException("Creating vehicle failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            logger.log("Error adding vehicle: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicles SET color = ?, fuelType = ?, manufacturer = ?, moving = ? WHERE vehicle_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vehicle.getColor());
            stmt.setString(2, vehicle.getFuelType());
            stmt.setString(3, vehicle.getManufacturer());
            stmt.setBoolean(4, vehicle.isMoving());
            stmt.setInt(5, vehicle.getVehicleId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                logger.log("Vehicle updated: " + vehicle.getManufacturer());
            } else {
                logger.log("Vehicle update failed: No vehicle found with ID " + vehicle.getVehicleId());
            }
        } catch (SQLException e) {
            logger.log("Error updating vehicle: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM vehicles WHERE vehicle_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                logger.log("Vehicle deleted with ID: " + vehicleId);
            } else {
                logger.log("vehicle deletion failed: No vehicle found with ID " + vehicleId);
            }
        } catch (SQLException e) {
            logger.log("Error deleting vehicle: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicle_id"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setFuelType(rs.getString("fuelType"));
                vehicle.setManufacturer(rs.getString("manufacturer"));
                vehicle.setMoving(rs.getBoolean("moving"));

                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            logger.log("Error retrieving all vehicles: " + e.getMessage());
            e.printStackTrace();
        }

        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        String sql = "SELECT * FROM vehicles WHERE vehicle_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleId(rs.getInt("vehicle_id"));
                    vehicle.setColor(rs.getString("color"));
                    vehicle.setFuelType(rs.getString("fuelType"));
                    vehicle.setManufacturer(rs.getString("manufacturer"));
                    vehicle.setMoving(rs.getBoolean("moving"));

                    return vehicle;
                }
            }
        } catch (SQLException e) {
            logger.log("Error retrieving vehicle by ID: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateVehiclePosition(int VehicleId, boolean increment) {
        return false;
    }

}
