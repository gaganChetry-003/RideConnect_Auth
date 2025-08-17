package com.example.uberauthservice.services;

import com.example.uberauthservice.helpers.AuthPassengerDetails;
import com.example.uberauthservice.models.Passenger;
import com.example.uberauthservice.repositories.PassengerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// responsible for loading the user details obj
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PassengerRepository passengerRepository;
    public UserDetailsServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);
        if(passenger.isPresent()) {
            return new AuthPassengerDetails((Passenger) passenger.get());
        }
        else
        {
            throw new UsernameNotFoundException("Cannot find the passenger with email: " + email);
        }

    }
}
