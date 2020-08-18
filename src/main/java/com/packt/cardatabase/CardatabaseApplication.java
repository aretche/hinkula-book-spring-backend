package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
public class CardatabaseApplication {

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final UserRepository userRepository;

    public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            // Save some cars
            carRepository.save(new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000, owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, owner1));
            carRepository.save(new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, owner2));

            // username: user password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }
}
