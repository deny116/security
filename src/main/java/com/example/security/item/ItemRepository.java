package com.example.security.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByIndeksContainsIgnoreCaseOrNameContainsIgnoreCaseOrHourPriceContainsIgnoreCase(String q1, String q2, String q3);
}