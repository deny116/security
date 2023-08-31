package com.example.security.web;

import com.example.security.Rental.RentalService;
import com.example.security.client.ClientService;
import com.example.security.item.ItemService;
import com.example.security.message.WelcomeMessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final WelcomeMessageService welcomeMessageService;

    RentalService rentalService;
    ClientService clientService;
    ItemService itemService;

    public HomeController(WelcomeMessageService welcomeMessageService, RentalService rentalService, ClientService clientService, ItemService itemService) {
        this.rentalService = rentalService;
        this.clientService = clientService;
        this.itemService = itemService;
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping("/")
    String home(@RequestParam(defaultValue = "en") String lang, Model model){
        String welcomeMessage = welcomeMessageService.getWelcomeMessage(lang);
        model.addAttribute("welcomeMessage", welcomeMessage);

        model.addAttribute("countClients", clientService.getCount());
        model.addAttribute("countItems", itemService.getCount());
        model.addAttribute("countRenal", rentalService.getCount());

        return "index";
    }

}
