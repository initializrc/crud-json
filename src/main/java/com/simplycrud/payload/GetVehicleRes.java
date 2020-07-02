package com.simplycrud.payload;

import com.simplycrud.model.Vehicle;

import java.util.List;

public class GetVehicleRes {

    private String errorcode;
    private String errorMessage;
    private List<Vehicle> vehicles;

    public GetVehicleRes() {
    }

    public GetVehicleRes(String errorcode, String errorMessage, List<Vehicle> vehicles) {
        this.errorcode = errorcode;
        this.errorMessage = errorMessage;
        this.vehicles = vehicles;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
