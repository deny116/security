package com.example.security.user.dto;

import com.example.security.user.User;
import com.example.security.user.UserRole;
import com.example.security.user.dto.UserCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDtoMapper {
    public static UserCredentialsDto map(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(email, password, roles);
    }
}
