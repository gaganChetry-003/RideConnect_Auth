package com.example.uberauthservice.dto;

import com.example.uberauthservice.models.Passenger;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Date createdAt;


    public static PassengerDto from (Passenger p) {

        PassengerDto result=PassengerDto.builder()
                .id(p.getId())
                .createdAt(p.getCreatedAt())
                .email(p.getEmail())
                .password(p.getPassword())
                .phoneNumber(p.getPhoneNumber())
                .name(p.getName())
                .build();
        return result;
    }

}
