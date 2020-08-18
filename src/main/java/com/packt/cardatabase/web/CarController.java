package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

}
