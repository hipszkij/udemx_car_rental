package eu.udemx.service;

import eu.udemx.domain.CarDomain;
import eu.udemx.dto.CarDto;
import eu.udemx.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Page<CarDto> findAll(String sortBy) {
        Page<CarDomain> list = carRepository.findAll(PageRequest.of(0, 20, Sort.by(sortBy)));

        return list.map(it -> {
            CarDto dto = new CarDto();
            BeanUtils.copyProperties(it, dto);

            return dto;
        });
    }

    public CarDto create(CarDto carDto) {
        CarDomain carDomain = new CarDomain();
        BeanUtils.copyProperties(carDto, carDomain);

        carDomain = carRepository.save(carDomain);
        BeanUtils.copyProperties(carDomain, carDto);

        return carDto;
    }

    public CarDto update(Long id, CarDto carDto) {
        CarDomain carDomain = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));

        BeanUtils.copyProperties(carDto, carDomain, "id", "createdAt");

        CarDomain updatedCarDomain = carRepository.save(carDomain);

        CarDto updatedCarDto = new CarDto();
        BeanUtils.copyProperties(updatedCarDomain, updatedCarDto);

        return updatedCarDto;
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }
}
