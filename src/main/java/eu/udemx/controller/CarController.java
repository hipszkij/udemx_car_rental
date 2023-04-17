package eu.udemx.controller;

import eu.udemx.dto.CarDto;
import eu.udemx.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<CarDto> fifthRestEndpoint() {
        return this.carService.findAll();
    }
}
