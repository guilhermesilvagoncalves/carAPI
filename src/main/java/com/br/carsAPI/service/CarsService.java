package com.br.carsAPI.service;

import com.br.carsAPI.model.Car;
import com.br.carsAPI.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car createNewCar(Car car) {
        Car newCar = new Car(car);
        return carRepository.save(newCar);
    }
}
