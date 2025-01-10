package dev.vorstu.controllers;

import dev.vorstu.dto.OwnerDto;
import dev.vorstu.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public List<OwnerDto> getOwner(){
        return ownerService.findAll();
    }

    @GetMapping(value = "/owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable("id") Long id){
        Optional<OwnerDto> ownerDto =ownerService.findById(id);
        return ownerDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
