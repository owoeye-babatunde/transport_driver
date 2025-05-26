package com.babsman.lesson.model;

import java.util.Objects;

public class Driver implements Comparable<Driver> {
    private Integer driverId;
    private String name;
    private String age;
    private String yearOfExperience;

    public Driver(){
    }

    public Driver(Integer driverId, String Name, String age, String yearOfExperience){
        this.driverId = driverId;
        this.name = Name;
        this.age = age;
        this.yearOfExperience = yearOfExperience;
    }

    public Driver(String Name, String age, String yearOfExperience){
        this(null, Name, age, yearOfExperience);
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getYearOfExperience() {
        return yearOfExperience;
    }

    public void setYearOfExperience(String yearOfExperience) {
        this.yearOfExperience = yearOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(driverId, driver.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", age='" + age + '\'' +
                ", yearOfExperience='" + yearOfExperience +
                '}';
    }



    public int compareTo(Driver other) {
        return this.age.compareTo(other.age);}
}
