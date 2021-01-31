package com.br.carsAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @PostMapping("cadastroAutomoveis")
    public ResponseEntity createNewCar(){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("automóveis")
    public ResponseEntity getaAllCars(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
