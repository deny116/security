package com.example.security.user;

import com.example.security.user.dto.UserCredentialsDto;
import com.example.security.user.dto.UserCredentialsDtoMapper;
import com.example.security.user.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
//    List<UserDto> findAll() {
//        return userRepository.findAll()
//                .stream()
//                .map(UserMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
}