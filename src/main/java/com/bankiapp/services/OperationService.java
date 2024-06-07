package com.bankiapp.services;

import com.bankiapp.entities.AccountBank;
import com.bankiapp.entities.Operation;

import java.util.List;

public interface OperationService {
    AccountBank effectuerVersement(String numCompte, double montant);
    AccountBank effectuerRetrait(String numCompte, double montant);
    List<Operation> findByClientNumCompte(String  numCompte);
    AccountBank virementFromOneCompteAToCompteB(String numCompteSource, String numCompteDestination, double montant);
}
