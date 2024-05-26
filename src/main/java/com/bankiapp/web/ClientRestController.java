package com.bankiapp.web;

import com.bankiapp.dto.ClientDTO;
import com.bankiapp.entities.Client;
import com.bankiapp.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ClientRestController {
    final private ClientService clientService;
    ClientRestController(final ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/clients")
    public String  createClient(@RequestBody ClientDTO dto){
        try{
            this.clientService.createClient(dto);
            return  "successful created";
        }catch (Exception e) {
            return  "error:" + e.getMessage();
        }
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
