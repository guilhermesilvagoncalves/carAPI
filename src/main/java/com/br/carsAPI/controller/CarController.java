package com.br.carsAPI.controller;

import com.br.carsAPI.model.Car;
import com.br.carsAPI.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarsService carsService;

    @PostMapping("cadastroAutomoveis")
    public ResponseEntity createNewCar(@RequestBody Car carRequest){
        Car carResponse = carsService.createNewCar(carRequest);
        return ResponseEntity.ok(carResponse);
    }

    @GetMapping("automoveis")
    public ResponseEntity getaAllCars(){
        List<Car> response = carsService.getAllCars();
        return ResponseEntity.ok(response);
    }
}
