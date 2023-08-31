package com.example.security.Rental;

import org.springframework.stereotype.Service;

@Service
class RentalMapper {
    static RentalDto map(Rental rental) {
        RentalDto dto = new RentalDto();
        dto.setId(rental.getId());
        dto.setStart(rental.getStart());
        dto.setEnd(rental.getEnd());
        dto.setStatus(rental.getStatus());
        dto.setClientId(rental.getClient().getId());
        dto.setFirstName(rental.getClient().getFirstName());
        dto.setLastName(rental.getClient().getLastName());
        dto.setItemId(rental.getItem().getId());
        dto.setItemIndeks(rental.getItem().getIndeks());
        dto.setItemName(rental.getItem().getName());
        dto.setItemHourPrice(rental.getItem().getHourPrice());
        return dto;
    }
    static Rental map(RentalDto dto) {
        Rental rental = new Rental();
        rental.setId(dto.getId());
        rental.setStart(dto.getStart());
        rental.setEnd(dto.getEnd());
        rental.setStatus(dto.getStatus());
        rental.setClient(dto.getClient());
        rental.setItem(dto.getItem());
        return rental;
    }
}
