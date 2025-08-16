package com.example.uberauthservice.repositories;

import com.example.uberauthservice.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
PassengerRepository extends JpaRepository<Passenger, Long> {
}
