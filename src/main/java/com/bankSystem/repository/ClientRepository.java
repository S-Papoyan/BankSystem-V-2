package com.bankSystem.repository;


import com.bankSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM client where if (?1 is not null, lower (name) like concat(lower(?1), '%'), true)")
    List<Client> searchClient(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM client where social_card = ? or passport_number = ? LIMIT 1")
    Optional<Client> getBySocialCardOrPassportNumber(String socialCard, String passportNumber);
}