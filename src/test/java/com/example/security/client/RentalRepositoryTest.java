package com.example.security.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentalRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    void given_when_then() {
        // given
        Client client = new Client();

        // when
        Client savedRental = clientRepository.save(client);

        // then
        Assertions.assertNotNull(savedRental, "savedRental is NULL");
    }
}