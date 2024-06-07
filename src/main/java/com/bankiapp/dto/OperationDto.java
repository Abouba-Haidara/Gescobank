package com.bankiapp.dto;

import com.bankiapp.entities.AccountBank;
import com.bankiapp.enums.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto {
    private long id;
    private Date dateOperation;
    private double amount;
    private TypeOperation type;
    private AccountBank compte;
    private String  numCompte;
    private String  numCompteD;
    private String  numCompteS;
}
