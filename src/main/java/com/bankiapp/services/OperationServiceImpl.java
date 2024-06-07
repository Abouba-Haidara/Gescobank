

package com.bankiapp.services;

import com.bankiapp.entities.AccountBank;
import com.bankiapp.entities.Operation;
import com.bankiapp.enums.AccountStatus;
import com.bankiapp.enums.TypeOperation;
import com.bankiapp.repositories.CompteBancaireRepository;
import com.bankiapp.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OperationServiceImpl implements OperationService{
    private final OperationRepository repoOp;
    private final CompteBancaireRepository  bancaireRepository;
    OperationServiceImpl(
            final CompteBancaireRepository  bancaireRepository,
            final OperationRepository repoOp) {
        this.repoOp = repoOp;
        this.bancaireRepository = bancaireRepository;
    }
    @Override
    public AccountBank effectuerVersement(String numCompte, double montant) {
        Optional<AccountBank> compteOpt = bancaireRepository.findByNumCompte(numCompte);
        if (compteOpt.isPresent()) {
            AccountBank compte = compteOpt.get();
            if (compte.getStatus().equals(AccountStatus.ACTIVATED)) {
                compte.setBalance(compte.getBalance() + montant);
                Operation operation = new Operation();
                operation.setDateOperation(new Date());
                operation.setAmount(montant);
                operation.setCompte(compte);
                operation.setType(TypeOperation.CREDIT);
                operation.setNumOperation(generateNumOp());
                this.repoOp.save(operation);

                return bancaireRepository.save(compte);
            }
        }else {
           throw   new RuntimeException("Le Compté est bloqué.");
        }
        return null;
    }

    @Override
    public AccountBank effectuerRetrait(String numCompte, double montant) {
        Optional<AccountBank> compteOpt = bancaireRepository.findByNumCompte(numCompte);
        if (compteOpt.isPresent()) {
            AccountBank compte = compteOpt.get();
            if (compte.getStatus().equals(AccountStatus.ACTIVATED)) {
                if (compte.getBalance() > montant) {
                    compte.setBalance(compte.getBalance() - montant);
                    compte = bancaireRepository.save(compte);
                    Operation operation = new Operation();
                    operation.setDateOperation(new Date());
                    operation.setAmount(montant);
                    operation.setCompte(compte);
                    operation.setType(TypeOperation.DEBIT);
                    operation.setNumOperation(generateNumOp());
                    this.repoOp.save(operation);
                } else {
                    throw new RuntimeException("Solde insuffisant");
                }
            }else {
                throw new RuntimeException("Le compte est bloqué, Opération Impossible");
            }
            return  compte;
        }
        return null;
    }

    @Override
    public List<Operation> findByClientNumCompte(String numCompte) {
        List<Operation> list =  new ArrayList<>();
        for(Operation o:this.repoOp.findAll()){
            if(o.getCompte().getNumCompte().equals(numCompte)){
                list.add(o);
            }
        }
        return list;
    }

    @Override
    public AccountBank virementFromOneCompteAToCompteB(String numCompteSource,String numCompteDestination, double montant) {
        AccountBank source = effectuerRetrait(numCompteSource, montant);
        if (source != null) {
            return effectuerVersement(numCompteDestination, montant);
        }
      return  null;
    }

    private static String generateNumOp() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append("0");
        }
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(2));
        }
        for (int i = 0; i < 3; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
