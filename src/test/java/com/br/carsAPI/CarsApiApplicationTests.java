package com.br.carsAPI;

import com.br.carsAPI.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarsApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldGetAllCarsOnGet(){
		ResponseEntity<List> response = this.restTemplate.getForEntity("http://localhost:" + port + "/automoveis", List.class);
		assertEquals(response.getBody().toString(),
				this.getExpectedGetAllResponse());
	}

	private String getExpectedGetAllResponse() {
		return "[{id=1, brand=Corsa, model=Classic, value=20000.0, createdAt=2021-01-31}]";
	}

	@Test
	void shouldPersistCreatedEntityOnCarPost(){
		Car requestedCar = this.getOneCarEntityForTests();
		Car createdCar = this.restTemplate.postForObject("http://localhost:" + port + "/cadastroAutomoveis", requestedCar , Car.class);
		assertEquals(createdCar.getBrand(), requestedCar.getBrand());
		assertEquals(createdCar.getModel(), requestedCar.getModel());
		assertEquals(createdCar.getValue(), requestedCar.getValue());
	}

	private Car getOneCarEntityForTests() {
		Car car = new Car();
		car.setBrand("Corsa");
		car.setModel("Classic");
		car.setValue(new BigDecimal(20000));
		return car;
	}

	private List<Car> getTwoCarsEntityForTests() {
		Car car1 = new Car();
		car1.setBrand("Hyundai");
		car1.setModel("HB20");
		car1.setValue(new BigDecimal(60000));

		Car car2 = new Car();
		car2.setBrand("Ecosport");
		car2.setModel("Ford");
		car2.setValue(new BigDecimal(80000));

		List<Car> listOfCars = new ArrayList<>();
		listOfCars.add(car1);
		listOfCars.add(car2);

		return listOfCars;
	}

}
