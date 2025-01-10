package dev.vorstu.controllers;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.dto.CredentialDto;
import dev.vorstu.service.BookingService;
import dev.vorstu.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public List<BookingDto> getBooking(){
        return bookingService.findAll();
    }
}
