package com.bankiapp.dto;

import com.bankiapp.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteBancaireDTO {
    private String numCompte;
    private  String devis;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private double tauxInteret;
    private double decouvert;
    private long clientId;
}
