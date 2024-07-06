package com.bankiapp.services;

import com.bankiapp.dto.ClientDTO;
import com.bankiapp.entities.Client;
import com.bankiapp.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;


    ClientServiceImpl(
            final ClientRepository repository
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
        return this.repository.findAll();
    }

    @Override
    public Client getClientById(long id) {
        return this.repository.findById(id).get();
    }
}
