package com.example.updemo.repository;

import com.example.updemo.domain.client.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    @Override
    List<Client> findAll();

    @Query("select c from Client c where c.id = :id")
    Optional<Client> findById(@Param("id") long id);

}
