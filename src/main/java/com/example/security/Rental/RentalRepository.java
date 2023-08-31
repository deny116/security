package com.example.security.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByStatusOrderByStartDesc(RentalStatus status);
    List<Rental> findAllByOrderByStartDesc();
}















