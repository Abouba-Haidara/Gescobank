package com.bankiapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("1")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Employee extends Person implements Serializable {
    private String codeEmployee;
    // Relation with un groups hiérarchique (auto-référencée)
    @ManyToOne
    @JoinColumn(name = "up_hierarchique_id")
    private Employee upHierarchique;
    // Relation with les groups
    @ManyToMany
    @JoinTable(
            name = "employee_group",
            joinColumns = @JoinColumn(name = "id"), /** Employee id */
            inverseJoinColumns = @JoinColumn(name = "id") /** group id */
    )
    private Set<Group> groups = new HashSet<>();
}
