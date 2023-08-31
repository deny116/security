package com.example.security.Rental;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    RentalRepository rentalRepository;
    RentalMapper rentalMapper;

    public RentalService(RentalRepository rentalRepository, RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;
        this.rentalMapper = rentalMapper;
    }
    public List<RentalDto> findAll() {
        return rentalRepository.findAll()
                .stream()
                .map(RentalMapper::map)
                .collect(Collectors.toList());
    }
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).get();
    }
    public RentalDto saveRental(RentalDto rentalDto) {
        Rental rental = RentalMapper.map(rentalDto);
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.map(savedRental);
    }
    public List<RentalDto> findAllByStatusOrderByStartDesc(RentalStatus status) {
        return rentalRepository.findAllByStatusOrderByStartDesc(status)
                .stream()
                .map(RentalMapper::map)
                .collect(Collectors.toList());
    }
    public List<RentalDto> findAllByOrderByStartDesc() {
        return rentalRepository.findAllByOrderByStartDesc()
                .stream()
                .map(RentalMapper::map)
                .collect(Collectors.toList());
    }
    public void updateRental(Rental rental) {
        rentalRepository.save(rental);
    }
    public void deleteRentalById(Long id) {
        rentalRepository.deleteById(id);
    }
    public long getCount() {
        return rentalRepository.count();
    }
}
