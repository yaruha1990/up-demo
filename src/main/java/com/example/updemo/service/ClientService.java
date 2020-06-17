package com.example.updemo.service;

import com.example.updemo.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDto save(ClientDto clientDto);

    Optional<ClientDto> findById(long id);

    List<ClientDto> findAll();

    void increaseClientBalance(long id, float amount);

}
