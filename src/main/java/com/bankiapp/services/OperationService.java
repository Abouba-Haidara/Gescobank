package com.bankiapp.services;

public interface OperationService {
    boolean effectuerVersement(long compteId, double montant);
    boolean effectuerRetrait(long compteId, double montant);
    boolean virementFromOneCompteAToCompteB(long compteAId, long compteBId, double montant);
}
