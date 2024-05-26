package com.bankiapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
    private Date birthDay;
    @JsonBackReference
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    Collection<CompteBancaire> comptes = new ArrayList<>();
}
