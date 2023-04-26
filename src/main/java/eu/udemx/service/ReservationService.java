package eu.udemx.service;

import eu.udemx.domain.ReservationDomain;
import eu.udemx.dto.ReservationDto;
import eu.udemx.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Page<ReservationDto> findAll(String sortBy) {
        Page<ReservationDomain> list = reservationRepository.findAll(PageRequest.of(0, 20, Sort.by(sortBy)));

        return list.map(it -> {
            ReservationDto dto = new ReservationDto();
            BeanUtils.copyProperties(it, dto);

            return dto;
        });
    }

    public ReservationDto create(ReservationDto reservationDto) {
        ReservationDomain reservationDomain = new ReservationDomain();

        reservationDto.setCreatedAt(LocalDateTime.now());
        BeanUtils.copyProperties(reservationDto, reservationDomain, "id");

        reservationDomain = reservationRepository.save(reservationDomain);
        BeanUtils.copyProperties(reservationDomain, reservationDto);

        return reservationDto;
    }

    public ReservationDto update(Long id, ReservationDto reservationDto) {
        ReservationDomain reservationDomain = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));

        BeanUtils.copyProperties(reservationDto, reservationDomain, "id", "createdAt");

        ReservationDomain updatedReservationDomain = reservationRepository.save(reservationDomain);

        ReservationDto updatedReservationDto = new ReservationDto();
        BeanUtils.copyProperties(updatedReservationDomain, updatedReservationDto);

        return updatedReservationDto;
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
