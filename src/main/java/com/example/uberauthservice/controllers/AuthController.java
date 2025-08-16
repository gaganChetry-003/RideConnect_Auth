package com.example.uberauthservice.controllers;


import com.example.uberauthservice.dto.PassengerDto;
import com.example.uberauthservice.dto.PassengerSignUpRequestDto;
import com.example.uberauthservice.services.AuthService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup/passenger")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto)
    {

        PassengerDto response= authService.signup(passengerSignUpRequestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/signin/passenger")
    public ResponseEntity<?>signIn()
    {
        return new ResponseEntity<>(10,HttpStatus.CREATED);
    }

}
