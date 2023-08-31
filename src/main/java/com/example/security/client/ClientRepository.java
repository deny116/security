package com.example.security.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    //Metoda, która pomoże odnaleźć wszystkich użytkowników :
    // kryterium: fragment nazwiska, ignorując wielkość liter
    //findAll, containin(zawierający), ingnoreCase
    List<Client> findAllByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrPeselContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String q1, String q2, String q3, String q4
    );

  //  List<Client> findAllByLastNameLike(String lastName);
}
