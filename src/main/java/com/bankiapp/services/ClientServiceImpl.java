package com.bankiapp.services;

import com.bankiapp.dto.ClientDTO;
import com.bankiapp.entities.Client;
import com.bankiapp.entities.Person;
import com.bankiapp.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final PersonRepository repository;
    ClientServiceImpl(
            final PersonRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public Client createClient(ClientDTO dto) {
        Client client = new Client();
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        client.setLastName(dto.getLastName());
        client.setFirstName(dto.getFirstName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(dto.getBirthday());
        } catch (ParseException e) {
            date = null;
        }
        client.setBirthday(date);
        return this.repository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clients = new ArrayList<>();
        for(Person p: this.repository.findAll())
            if(p instanceof  Client) clients.add((Client) p);
        return clients;
    }

    @Override
    public Client getClientById(long id) {
        Person p = this.repository.findById(id).orElse(null);
        if(p instanceof  Client)  return (Client) p;
        return null;
    }

    @Override
    public List<Client> searchClientsByKeywords(String keyword) {
       List<Client> clients =  new ArrayList<>();
       for(Person p:this.repository.findByFirstNameContaining(keyword))
       {
           if(p instanceof  Client) {
               clients.add((Client) p);
           }
       }
     return  clients;
    }
}
