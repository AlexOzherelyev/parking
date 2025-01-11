package dev.vorstu.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import dev.vorstu.dto.*;
import dev.vorstu.dto.auth.SignInRequest;
import dev.vorstu.dto.mapper.OwnerMapper;
import dev.vorstu.entity.Owner;
import dev.vorstu.entity.Parking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitializerService {

    @Lazy
    @Autowired
    private final ParkingService parkingService;
    @Lazy
    @Autowired
    private final OwnerService ownerService;
    @Lazy
    @Autowired
    private final UserService userService;

    @Lazy
    @Autowired
    private final CredentialService credentialService;

    @Lazy
    @Autowired
    private final BookingService bookingService;

    public void initial(){

        CredentialDto credentialDto = credentialService.create(CredentialDto.builder()
                .username("abc")
                .password("123")
                .role(Role.USER)
                .build());

        UserDto userDto = userService.create(UserDto.builder()
                .fio("Мапперов Алексей Вячеславович")
                .phone("+79876543210")
                .email("adjalkdaljda@dajdlajdada.com")
                .credentialId(credentialDto.getId()).build());

        OwnerDto ownerDto = ownerService.create(OwnerDto.builder()
                .isApproved(false)
                .userId(userDto.getId()).build());

        CredentialDto credentialDto1 = credentialService.create(CredentialDto.builder()
                .username("user")
                .password("123")
                .role(Role.USER)
                .build());

        UserDto userDto1 = userService.create(UserDto.builder()
                .fio("ПОПОВ Алексей Вячеславович")
                .phone("+79876543210")
                .email("adjalkdaljda@dajdlajdada.com")
                .credentialId(credentialDto1.getId()).build());

        OwnerDto ownerDto1 = ownerService.create(OwnerDto.builder()
                .isApproved(false)
                .userId(userDto1.getId()).build());

        ParkingDto parkingDto = parkingService.create(ParkingDto.builder()
                .address("воронеж")
                .code("abc")
                .price(1000L)
                .timeStart(new Date())
                .timeEnd(new Date(System.currentTimeMillis() + (2 * 60 * 60 * 1000)))
                .ownerId(ownerDto.getId())
                .booking(null).build());

    }

}
