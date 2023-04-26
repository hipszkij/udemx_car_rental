package eu.udemx.controller;

import eu.udemx.dto.ReservationDto;
import eu.udemx.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    private Page<ReservationDto> getCar(@RequestParam String sortBy) {
        return this.reservationService.findAll(sortBy);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    private ReservationDto createCar(@RequestBody ReservationDto reservationDto) {
        return reservationService.create(reservationDto);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ReservationDto updateCar(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        return reservationService.update(id, reservationDto);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void deleteCar(@PathVariable Long id) {
        reservationService.delete(id);
    }
}
