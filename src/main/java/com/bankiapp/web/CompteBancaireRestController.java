package com.bankiapp.web;

import com.bankiapp.dto.CompteBancaireDTO;
import com.bankiapp.entities.CompteBancaire;
import com.bankiapp.entities.CompteCourant;
import com.bankiapp.entities.CompteEpargne;
import com.bankiapp.services.CompteBancaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CompteBancaireRestController {
    private final CompteBancaireService bancaireService;
    CompteBancaireRestController(final CompteBancaireService bancaireService) {
        this.bancaireService = bancaireService;
    }

    @PostMapping("/comptes")
    String createCompte(@RequestBody CompteBancaireDTO dto){
        try {
            this.bancaireService.createCompte(dto);
            return  "successful created";
        }catch (Exception e) {
            return "error:" + e.getMessage();
        }
    }

    @GetMapping("/comptes/{type}")
    ResponseEntity<?> findAllCompte(@PathVariable("type") String type){
       try {
           List<CompteBancaire> list =new ArrayList<>();
           for(CompteBancaire c: this.bancaireService.findAll()) {
               if(type.equals("CE") && c instanceof CompteEpargne) {
                   list.add(c);
               }
               if(type.equals("CC") && c instanceof CompteCourant) {
                   list.add(c);
               }
           }
           return ResponseEntity.ok(list);
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return null;
    }


    @GetMapping("/comptes/courant/{id}")
    ResponseEntity<?> findCompteCourant(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.bancaireService.findCompteCourant(id));
    }

    @GetMapping("/comptes/epargne/{id}")
    ResponseEntity<?> findCompteEpargne(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.bancaireService.findCompteEpargne(id));
    }
}

