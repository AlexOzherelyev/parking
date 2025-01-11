package dev.vorstu.controllers;

import dev.vorstu.dto.BookingDto;
import dev.vorstu.dto.CredentialDto;
import dev.vorstu.dto.ParkingDto;
import dev.vorstu.service.BookingService;
import dev.vorstu.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingDto createBooking(@RequestBody BookingDto newBooking) {
        return bookingService.create(newBooking);
    }
}
