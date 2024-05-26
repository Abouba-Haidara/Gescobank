package com.bankiapp.services;

import com.bankiapp.dto.CompteBancaireDTO;
import com.bankiapp.entities.CompteBancaire;
import com.bankiapp.entities.CompteCourant;
import com.bankiapp.entities.CompteEpargne;

import java.util.List;

public interface CompteBancaireService {
  void createCompte(CompteBancaireDTO dto);
  List<CompteBancaire> findAll();
  CompteEpargne findCompteEpargne(long id);
  CompteCourant findCompteCourant(long id);
}
