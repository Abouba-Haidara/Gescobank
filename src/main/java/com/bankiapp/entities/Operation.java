package com.bankiapp.entities;

import com.bankiapp.enums.TypeOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date dateOperation;
    private double mount;
    private TypeOperation type;
    @ManyToOne
    private CompteBancaire compte;
}
