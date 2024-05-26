package com.bankiapp.services;

import com.bankiapp.entities.Client;

import java.util.List;

public interface ClientService {
    void createClient(Client client);
    List<Client> getAllClient();
    Client getClientById(long id);
}
