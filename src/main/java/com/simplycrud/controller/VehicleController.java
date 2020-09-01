package com.simplycrud.controller;

import com.simplycrud.model.Vehicle;
import com.simplycrud.payload.*;
import com.simplycrud.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleRepo vehicleRepo;

    @PostMapping(value = "/inputVehicle")
    public ResponseEntity<PostVehicleRes> inputVehicle(@Valid @RequestBody InputVehicleReq inputVehicleReq){
        Boolean isExists = vehicleRepo.existsVehicleByPlateNumber(inputVehicleReq.getPlateNumber());
        if (isExists){
            PostVehicleRes postVehicleRes = new PostVehicleRes("300","Vehicle Is Exists",vehicleRepo.findVehicleByPlateNumber(inputVehicleReq.getPlateNumber()));
            return new ResponseEntity<>(postVehicleRes, HttpStatus.OK);
        }
        Vehicle vehicle = new Vehicle(
                inputVehicleReq.getBrand(),
                inputVehicleReq.getType(),
                inputVehicleReq.getPlateNumber(),
                inputVehicleReq.getYear());
        vehicleRepo.save(vehicle);

        PostVehicleRes postVehicleRes = new PostVehicleRes("200","Sukses",vehicle);
        return new ResponseEntity<>(postVehicleRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/getVehicles")
    public ResponseEntity<GetVehicleRes> getVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepo.findAll();

        GetVehicleRes getVehicleRes = new GetVehicleRes("200","Sukses",vehicles);
        return new ResponseEntity<>(getVehicleRes, HttpStatus.OK);
    }

    @RequestMapping(value = "getVehiclesByYear")
    public ResponseEntity<GetVehicleRes> getVehiclesByYear(@RequestParam int year){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = vehicleRepo.findAllByYear(year);

        if (vehicles.isEmpty()){
            GetVehicleRes getVehicleRes = new GetVehicleRes("404","Not Found",vehicles);
            return new ResponseEntity<>(getVehicleRes, HttpStatus.OK);
        }

        GetVehicleRes getVehicleRes = new GetVehicleRes("202","Sukses",vehicles);
        return new ResponseEntity<>(getVehicleRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/getVehicleCustom")
    public ResponseEntity<GetVehicleCustomRes> getVehicleCustom(@RequestParam int year){
        GetVehicleCustomRes getVehicleCustomRes = new GetVehicleCustomRes(
                "200",
                "Sukses",
                vehicleRepo.findByYearGreaterThan(year).size(),
                vehicleRepo.findByYearGreaterThan(year),
                vehicleRepo.findByYearLessThan(year).size(),
                vehicleRepo.findByYearLessThan(year)
        );
        return new ResponseEntity<>(getVehicleCustomRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateVehicleYearByPlateNumber")
    public ResponseEntity<PostVehicleRes> updateVehicleYearByPlateNumber(@RequestParam String plateNumber, int year){
        Vehicle vehicle = new Vehicle();
        vehicle = vehicleRepo.findVehicleByPlateNumber(plateNumber);
        if (vehicle == null){
            PostVehicleRes postVehicleRes = new PostVehicleRes("404","Not Found",null);
            return new ResponseEntity<>(postVehicleRes, HttpStatus.OK);
        }
        vehicle.setYear(year);
        vehicleRepo.save(vehicle);

        PostVehicleRes postVehicleRes = new PostVehicleRes("200","Sukes",vehicle);
        return new ResponseEntity<>(postVehicleRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteVehicleByplateNumber")
    public ResponseEntity<DeleteVehicleRes> deleteVehicleByPlateNumber(@RequestParam String plateNumber){
        Vehicle vehicle = new Vehicle();
        vehicle = vehicleRepo.findVehicleByPlateNumber(plateNumber);

        if (vehicle==null){
            DeleteVehicleRes deleteVehicleRes = new DeleteVehicleRes("404","Not Found",null);
            return new ResponseEntity<>(deleteVehicleRes, HttpStatus.OK);
        }
        vehicleRepo.delete(vehicle);
        DeleteVehicleRes deleteVehicleRes = new DeleteVehicleRes("200","vehicle berhasil dihapus",vehicle);
        return new ResponseEntity<>(deleteVehicleRes, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteVehicleById")
    public ResponseEntity<DeleteVehicleRes> deleteVehicleById(@RequestParam long id){
        Vehicle vehicle = new Vehicle();
        vehicle= vehicleRepo.findVehicleById(id);
        if (vehicle == null){
            DeleteVehicleRes deleteVehicleRes = new DeleteVehicleRes("404","Not Found",null);
            return new ResponseEntity<>(deleteVehicleRes, HttpStatus.OK);
        }

        vehicleRepo.delete(vehicle);
        DeleteVehicleRes deleteVehicleRes = new DeleteVehicleRes("200","vehicle berhasil dihapus",vehicle);
        return new ResponseEntity<>(deleteVehicleRes, HttpStatus.OK);
    }
}
