package com.bankiapp.services;

import com.bankiapp.dto.CompteBancaireDTO;
import com.bankiapp.entities.Client;
import com.bankiapp.entities.CompteBancaire;
import com.bankiapp.entities.CompteCourant;
import com.bankiapp.entities.CompteEpargne;
import com.bankiapp.repositories.ClientRepository;
import com.bankiapp.repositories.CompteBancaireRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompteBancaireServiceImpl implements CompteBancaireService{

    private final CompteBancaireRepository bancaireRepository;
    private final ClientRepository clientRepository;
    CompteBancaireServiceImpl(
            final CompteBancaireRepository bancaireRepository,
            final ClientRepository clientRepository
            ) {
        this.bancaireRepository = bancaireRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void createCompte(CompteBancaireDTO dto) {
        Client client;
        boolean isPresent = this.clientRepository.findById(dto.getClientId()).isPresent();

        if(isPresent && dto.getDecouvert() == 0 && dto.getTauxInteret() > 0 ) {
         client =  this.clientRepository.getReferenceById(dto.getClientId());
         CompteEpargne compteEpargne = new  CompteEpargne();
         compteEpargne.setClient(client);
         compteEpargne.setCreatedAt(new Date());
         compteEpargne.setDevis("CFA");
         compteEpargne.setBalance(dto.getBalance());
         compteEpargne.setTauxInteret(dto.getTauxInteret());

         this.bancaireRepository.save(compteEpargne);
        }

        if(isPresent && dto.getTauxInteret()  == 0 && dto.getDecouvert() > 0)
        {
            client =  this.clientRepository.getReferenceById(dto.getClientId());
            CompteCourant compteCourant = new CompteCourant();
            compteCourant.setClient(client);
            compteCourant.setBalance(dto.getBalance());
            compteCourant.setDevis("CFA");
            compteCourant.setCreatedAt(new Date());
            compteCourant.setDecouvert(dto.getDecouvert());

            this.bancaireRepository.save(compteCourant);
        }
    }

    @Override
    public List<CompteBancaire> findAll() {
        return this.bancaireRepository.findAll();
    }

    @Override
    public CompteEpargne findCompteEpargne(long id) {
        return (CompteEpargne)this.bancaireRepository.getReferenceById(id);
    }

    @Override
    public CompteCourant findCompteCourant(long id) {
        return (CompteCourant)this.bancaireRepository.getReferenceById(id);
    }

}
