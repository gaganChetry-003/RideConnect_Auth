package com.example.uberauthservice.services;


import com.example.uberauthservice.dto.PassengerDto;
import com.example.uberauthservice.dto.PassengerSignUpRequestDto;
import com.example.uberauthservice.models.Passenger;
import com.example.uberauthservice.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthService(PassengerRepository passengerRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    public PassengerDto signup(PassengerSignUpRequestDto passengerSignUpRequestDto) {

        Passenger passenger = Passenger.builder()
                .email(passengerSignUpRequestDto.getEmail())
                .name(passengerSignUpRequestDto.getName())
                .phoneNumber(passengerSignUpRequestDto.getPhone())
                .password(bCryptPasswordEncoder.encode(passengerSignUpRequestDto.getPassword()))
                .build();


       Passenger newPassenger= passengerRepository.save(passenger);
       return PassengerDto.from(newPassenger);



    }
}
