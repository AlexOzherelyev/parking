package dev.vorstu.service;


import dev.vorstu.dto.CredentialDto;
import dev.vorstu.dto.mapper.CredentialMapper;
import dev.vorstu.entity.Credential;
import dev.vorstu.repositories.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class CredentialService {

    private final CredentialRepository credentialRepository;
    private final CredentialMapper mapper;
    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CredentialDto create(CredentialDto credentialDto) {
        credentialDto.setPassword(passwordEncoder.encode(credentialDto.getPassword()));
        return mapper.entityToDto(
                credentialRepository.save(mapper.dtoToEntity(credentialDto))
        );
    }

    public CredentialDto update(CredentialDto credentialDto) {
        return mapper.entityToDto(
                credentialRepository.save(mapper.dtoToEntity(credentialDto))
        );
    }

    public Long delete(Long id) {
        credentialRepository.deleteById(id);
        return id;
    }

    public List<CredentialDto> findAll() {
        return mapper.toList(
                credentialRepository.findAll());
    }

    public Credential getByUsername(String username) {
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public Credential getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
