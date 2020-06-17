package com.example.updemo.dto.mapper;

import com.example.updemo.domain.client.Client;
import com.example.updemo.dto.ClientDto;
import com.example.updemo.dto.ClientWithoutCartsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartMapper.class)
public interface ClientMapper {
    @Mapping(target = "id", source = "client.id")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "balance", source = "client.balance")
    @Mapping(target = "carts", source = "client.carts")
    ClientDto clientToDto(Client client);

    @Mapping(target = "id", source = "clientDto.id")
    @Mapping(target = "email", source = "clientDto.email")
    @Mapping(target = "balance", source = "clientDto.balance")
    ClientWithoutCartsDto clientDtoToClientWithoutCartsDto(ClientDto clientDto);

    @Mapping(target = "id", source = "clientDto.id")
    @Mapping(target = "email", source = "clientDto.email")
    @Mapping(target = "balance", source = "clientDto.balance")
    @Mapping(target = "carts", source = "clientDto.carts")
    Client clientDtoToClient(ClientDto clientDto);
}
