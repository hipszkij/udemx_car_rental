package eu.udemx.controller;

import eu.udemx.dto.CarDto;
import eu.udemx.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    private Page<CarDto> getCar(@RequestParam String sortBy) {
        return this.carService.findAll(sortBy);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    private CarDto createCar(@RequestBody CarDto carDto) {
        return carService.create(carDto);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private CarDto updateCar(@PathVariable Long id, @RequestBody CarDto carDto) {
        return carService.update(id, carDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void deleteCar(@PathVariable Long id) {
        carService.delete(id);
    }
}
