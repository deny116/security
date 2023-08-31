package com.example.security.web;

import com.example.security.Rental.*;
import com.example.security.client.Client;
import com.example.security.client.ClientService;
import com.example.security.item.Item;
import com.example.security.item.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class RentalController {

    RentalService rentalService;
    ClientService clientService;
    ItemService itemService;
    RentalRepository rentalRepository;

    public RentalController(RentalService rentalService, ClientService clientService, ItemService itemService, RentalRepository rentalRepository) {
        this.rentalService = rentalService;
        this.clientService = clientService;
        this.itemService = itemService;
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/rentals")
    public String listRentals(@RequestParam(required = false) RentalStatus status, Model model) {
        List<RentalDto> rentals;

        if (status == null)
            rentals = rentalService.findAllByOrderByStartDesc();
        else
            rentals = rentalService.findAllByStatusOrderByStartDesc(status);

        model.addAttribute("rentals", rentals);

        List<Client> clients;
        clients = clientService.getAllClient();
        model.addAttribute("clients", clients);

        return "rentalList";
    }

    @GetMapping("/rentals/new")
    public String createRentalForm(Model model) {
        RentalDto rentalDto = new RentalDto();
        rentalDto.setStatus(RentalStatus.NEW);
        model.addAttribute("rental", rentalDto);

        List<Client> clients;
        clients = clientService.getAllClient();
        model.addAttribute("clients", clients);

        List<Item> items;
        items = itemService.getAllItem();
        model.addAttribute("items", items);

        return "rentalStore";
    }

    @PostMapping("/rentals")
    public String saveRental(@ModelAttribute("rentals") RentalDto rentalDto) {
        rentalService.saveRental(rentalDto);
        return "redirect:/rentals?savesuccess";
    }

    @GetMapping("/rentals/edit/{id}")
    public String editRentalForm(@PathVariable Long id, Model model) {
        model.addAttribute("rental", rentalService.getRentalById(id));

        List<Client> clients;
        clients = clientService.getAllClient();
        model.addAttribute("clients", clients);

        List<Item> items;
        items = itemService.getAllItem();
        model.addAttribute("items", items);

        return "rentalStore";
    }

    @PostMapping("rentals/{id}")
    public String updateRental(@PathVariable Long id, @ModelAttribute("rentals") Rental rental) {
        Rental existingRental = rentalService.getRentalById(id);
        existingRental.setId(id);
        existingRental.setStart(rental.getStart());
        existingRental.setEnd(rental.getEnd());
        existingRental.setClient(rental.getClient());
        existingRental.setItem(rental.getItem());
        existingRental.setStatus(rental.getStatus());
        rentalService.updateRental(existingRental);
        return "redirect:/rentals?updatesuccess";
    }

    @GetMapping("/rentals/{id}")
    public String deleteRental(@PathVariable Long id) {
        rentalService.deleteRentalById(id);
        return "redirect:/rentals?deletesuccess";
    }
}





