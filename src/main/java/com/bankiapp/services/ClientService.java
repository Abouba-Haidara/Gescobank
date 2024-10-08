package com.bankiapp.services;

import com.bankiapp.dto.ClientDTO;
import com.bankiapp.entities.Client;

import java.util.List;

public interface ClientService {
    Client createClient(ClientDTO dto);
    List<Client> getAllClient();
    Client getClientById(long id);
    List<Client> searchClientsByKeywords(String keyword);
}
