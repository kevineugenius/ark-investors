package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Client;
import com.ark.kesmith.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    // todo: who is even calling this?
    @PostMapping("/add")
    public void addClient(@RequestBody Client client) {
        System.out.println("Client service returned: " + clientService.addClient(client));
    }
}
