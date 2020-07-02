package com.simplycrud.payload;

import com.simplycrud.model.Vehicle;

public class PostVehicleRes {

    private String errorCode;
    private String errorMessage;
    private Vehicle vehicle;

    public PostVehicleRes() {
    }

    public PostVehicleRes(String errorCode, String errorMessage, Vehicle vehicle) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
