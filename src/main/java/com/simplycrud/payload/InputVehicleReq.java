package com.simplycrud.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InputVehicleReq {

    @NotBlank
    private String brand;
    private String type;
    private String plateNumber;

    @NotNull
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
