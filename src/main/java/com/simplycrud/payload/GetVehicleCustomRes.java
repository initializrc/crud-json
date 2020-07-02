package com.simplycrud.payload;

import com.simplycrud.model.Vehicle;

import java.util.List;

public class GetVehicleCustomRes {

    private String errorCode;
    private String errorMessage;
    private int countGreaterThanYear;
    private List<Vehicle> vehiclesGreaterThanYear;
    private int countLessThanYear;
    private List<Vehicle> vehiclesLessThanYear;

    public GetVehicleCustomRes() {
    }

    public GetVehicleCustomRes(String errorCode, String errorMessage, int countGreaterThanYear, List<Vehicle> vehiclesGreaterThanYear, int countLessThanYear, List<Vehicle> vehiclesLessThanYear) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.countGreaterThanYear = countGreaterThanYear;
        this.vehiclesGreaterThanYear = vehiclesGreaterThanYear;
        this.countLessThanYear = countLessThanYear;
        this.vehiclesLessThanYear = vehiclesLessThanYear;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getCountGreaterThanYear() {
        return countGreaterThanYear;
    }

    public void setCountGreaterThanYear(int countGreaterThanYear) {
        this.countGreaterThanYear = countGreaterThanYear;
    }

    public List<Vehicle> getVehiclesGreaterThanYear() {
        return vehiclesGreaterThanYear;
    }

    public void setVehiclesGreaterThanYear(List<Vehicle> vehiclesGreaterThanYear) {
        this.vehiclesGreaterThanYear = vehiclesGreaterThanYear;
    }

    public int getCountLessThanYear() {
        return countLessThanYear;
    }

    public void setCountLessThanYear(int countLessThanYear) {
        this.countLessThanYear = countLessThanYear;
    }

    public List<Vehicle> getVehiclesLessThanYear() {
        return vehiclesLessThanYear;
    }

    public void setVehiclesLessThanYear(List<Vehicle> vehiclesLessThanYear) {
        this.vehiclesLessThanYear = vehiclesLessThanYear;
    }
}
