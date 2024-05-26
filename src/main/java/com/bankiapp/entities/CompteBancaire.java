package com.bankiapp.entities;

import com.bankiapp.enums.AccountStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type",
        discriminatorType = DiscriminatorType.INTEGER)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public abstract class  CompteBancaire implements Serializable {
    @Serial
    private static final long serialVersionUID = -8885817712041252438L;

    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    long id;
    private String numCompte;
    private  String devis;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    @ManyToOne
    private Client client;
    @JsonBackReference
    @OneToMany(mappedBy = "compte", fetch = FetchType.LAZY)
    private Collection<Operation> operations = new ArrayList<>();
}
