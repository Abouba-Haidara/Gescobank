package com.bankiapp.web;

import com.bankiapp.dto.ClientDTO;
import com.bankiapp.entities.Client;
import com.bankiapp.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class ClientRestController {
    final private ClientService clientService;
    ClientRestController(final ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/clients")
    public Client  createClient(@RequestBody ClientDTO dto){
        return this.clientService.createClient(dto);
    }
    @GetMapping("/clients")
    List<Client> findAll() {
        return this.clientService.getAllClient();
    }
    @GetMapping("/clients/{id}")
    Client findAll(@PathVariable("id") long id) {
        try {
            return this.clientService.getClientById(id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
