package com.bankiapp.services;

import com.bankiapp.dto.CompteBancaireDTO;
import com.bankiapp.entities.AccountBank;
import com.bankiapp.entities.CompteCourant;
import com.bankiapp.entities.CompteEpargne;

import java.util.List;

public interface CompteBancaireService {
  void createCompte(CompteBancaireDTO dto);
  List<CompteCourant> findAllCompteCourant();
  List<CompteEpargne> findAllCompteEpargne();
  CompteEpargne findCompteEpargne(String numCompte);
  CompteCourant findCompteCourant(String numCompte);
  AccountBank suspendCompte(String numCompte);
  AccountBank activeCompte(String numCompte);


}
