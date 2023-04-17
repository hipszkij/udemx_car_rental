package eu.udemx.service;

import eu.udemx.domain.CarDomain;
import eu.udemx.dto.CarDto;
import eu.udemx.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> findAll() {
        List<CarDomain> list = carRepository.findAll();

        return list.stream().map(it -> {
            CarDto dto = new CarDto();
            dto.setName(it.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}
