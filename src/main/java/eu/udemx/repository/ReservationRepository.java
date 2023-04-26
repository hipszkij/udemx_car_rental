package eu.udemx.repository;

import eu.udemx.domain.ReservationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationDomain, Long> { }