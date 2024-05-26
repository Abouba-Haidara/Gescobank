package com.bankiapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private  String lastName;
    private String email;
    private String telephone;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    Collection<CompteBancaire> comptes = new ArrayList<>();
}
