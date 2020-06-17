package com.example.updemo.service.impl;

import com.example.updemo.domain.client.Client;
import com.example.updemo.dto.ClientDto;
import com.example.updemo.dto.mapper.ClientMapper;
import com.example.updemo.repository.ClientRepository;
import com.example.updemo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto save(ClientDto clientDto) {
        Client client = clientMapper.clientDtoToClient(clientDto);
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    public Optional<ClientDto> findById(long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(clientMapper::clientToDto);
    }

    @Override
    public List<ClientDto> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::clientToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void increaseClientBalance(long id, float amount) {
        clientRepository.findById(id).ifPresent(client -> {
            float newBalance = client.getBalance() + amount;
            client.setBalance(newBalance);
            clientRepository.save(client);
        });
    }
}
