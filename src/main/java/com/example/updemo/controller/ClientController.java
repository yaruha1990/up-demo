package com.example.updemo.controller;

import com.example.updemo.dto.ClientDto;
import com.example.updemo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable("id") long id) {
        Optional<ClientDto> clientDto = clientService.findById(id);
        return clientDto.map(ResponseEntity::ok).orElseGet(() -> badRequest().build());
    }

    @PostMapping
    public ClientDto save(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @PostMapping("/increaseBalance")
    public void increaseClientBalance(@RequestParam("id") long id, @RequestParam("amount") float amount) {
        clientService.increaseClientBalance(id, amount);
    }

}
