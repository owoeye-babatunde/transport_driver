package com.babsman.lesson.model;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {

    private Integer vehicleId;
    private String color;
    private String fuelType;
    private String manufacturer;
    private boolean moving;

    public Vehicle(){
    }

    public Vehicle(Integer vehicleId, String color, String fuelType, String manufacturer, boolean moving){
        this.vehicleId = vehicleId;
        this.color = color;
        this.fuelType = fuelType;
        this.manufacturer = manufacturer;
        this.moving = moving;
    }

    public Vehicle(String color, String fuelType, String manufacturer, boolean moving){
        this(null, color, fuelType, manufacturer, moving);
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", moving=" + moving +
                '}';
    }

    public int compareTo(Vehicle other) {
        return this.color.compareTo(other.color);}


}
