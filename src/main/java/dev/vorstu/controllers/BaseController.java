package dev.vorstu.controllers;

import dev.vorstu.dto.CredentialDto;
import dev.vorstu.dto.OwnerDto;
import dev.vorstu.dto.ParkingDto;
import dev.vorstu.dto.UserDto;
import dev.vorstu.service.CredentialService;
import dev.vorstu.service.OwnerService;
import dev.vorstu.service.ParkingService;
import dev.vorstu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BaseController {

    private final ParkingService parkingService;
    private final OwnerService ownerService;
    private final UserService userService;
    private final CredentialService credentialService;

    @GetMapping
    public List<ParkingDto>getParking(){
        return parkingService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ParkingDto createStudent(@RequestBody ParkingDto newParking) {
        return parkingService.create(newParking);
    }
}
