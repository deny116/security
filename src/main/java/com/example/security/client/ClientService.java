package com.example.security.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findByQuery(String q) {
        return clientRepository.findAllByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrPeselContainingIgnoreCaseOrEmailContainingIgnoreCase(q, q, q, q)
                .stream()
                .collect(Collectors.toList());
    }

    public long getCount() {
        return clientRepository.count();
    }
}





