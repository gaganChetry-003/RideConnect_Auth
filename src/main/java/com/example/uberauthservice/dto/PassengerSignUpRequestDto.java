package com.example.uberauthservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerSignUpRequestDto {
     private String name;
    private String email;
     private String password;
     private String phone;
}
