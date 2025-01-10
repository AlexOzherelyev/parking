package dev.vorstu.controllers;

import dev.vorstu.dto.CredentialDto;
import dev.vorstu.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CredentialController {

    private final CredentialService credentialService;
    @GetMapping
    public List<CredentialDto> getCredential(){
        return credentialService.findAll();
    }
}
