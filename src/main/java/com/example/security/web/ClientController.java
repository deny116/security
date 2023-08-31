package com.example.security.web;

import com.example.security.client.Client;
import com.example.security.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/clients")
    public String listClients(Model model, String q) {
        model.addAttribute("clients", q != null ? clientService.findByQuery(q) : clientService.getAllClient());
        return "clientList";
    }
    @GetMapping("/clients/new")
    public String createClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "clientStore";
    }
    @PostMapping("/clients")
    public String saveClient(@ModelAttribute("clients") Client client) {
        clientService.saveClient(client);
        return "redirect:/clients?savesuccess";
    }
    @GetMapping("/clients/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "clientStore";
    }
    @PostMapping("/clients/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute("Client") Client client, Model model) {
        Client existingClient = clientService.getClientById(id);
        existingClient.setId(id);
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setPesel(client.getPesel());
        existingClient.setEmail(client.getEmail());
        clientService.updateClient(existingClient);
        return "redirect:/clients?updatesuccess";
    }
    @GetMapping("/clients/{id}")
    public String deleteCLient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clients?deletesuccess";
    }
}