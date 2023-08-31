package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //nadpisanie stockowej strony głównej
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        // Wszystkie żadania wysyłane do aplikacji wymagają uwierzetelnienia
        http.authorizeHttpRequests(requests ->
                requests.antMatchers("/h2/**", "/h2-console/**").permitAll().anyRequest().authenticated()
        );
        http.formLogin(form -> form.loginPage("/login").permitAll());

        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder userBuilder = User.builder();
//        UserDetails admin = userBuilder.username("Damian").password("{noop}admin").roles("ADMIN").build();
//        UserDetails user1 = userBuilder.username("Magda").password("{noop}password").roles("USER").build();
//        return new InMemoryUserDetailsManager(admin,user1);
//    }
}
