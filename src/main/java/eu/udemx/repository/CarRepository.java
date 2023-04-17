package eu.udemx.repository;

import eu.udemx.domain.CarDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarDomain, Long> { }