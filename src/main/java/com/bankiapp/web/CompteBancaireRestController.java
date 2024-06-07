package com.bankiapp.web;

import com.bankiapp.dto.CompteBancaireDTO;
import com.bankiapp.entities.Operation;
import com.bankiapp.services.CompteBancaireService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class CompteBancaireRestController {
    private final CompteBancaireService bancaireService;
    CompteBancaireRestController(final CompteBancaireService bancaireService) {
        this.bancaireService = bancaireService;
    }

    @PostMapping("/comptes")
    CompteBancaireDTO createCompte(@RequestBody CompteBancaireDTO dto){
       this.bancaireService.createCompte(dto);;
       return  dto;
    }

    @GetMapping("/comptes")
    List<?> findAllCompte(@Param("type") String type){
        if(type.equals("CC"))
            return this.bancaireService.findAllCompteCourant();
        if(type.equals("CE"))
            return this.bancaireService.findAllCompteEpargne();
        return null;
    }


    @GetMapping("/comptes/courant/{numCompte}")
    ResponseEntity<?> findCompteCourant(@PathVariable("numCompte") String numCompte) {
        return ResponseEntity.ok(this.bancaireService.findCompteCourant(numCompte));
    }

    @GetMapping("/comptes/epargne/{numCompte}")
    ResponseEntity<?> findCompteEpargne(@PathVariable("numCompte") String numCompte) {
        return ResponseEntity.ok(this.bancaireService.findCompteEpargne(numCompte));
    }

    @GetMapping("/comptes/active/{numCompte}")
    boolean activeCompte(@PathVariable("numCompte") String numCompte) {
        this.bancaireService.activeCompte(numCompte);
        return true;
    }

    @GetMapping("/comptes/suspendre/{numCompte}")
    boolean suspendreCompte(@PathVariable("numCompte") String numCompte) {
        this.bancaireService.suspendCompte(numCompte);
        return true;
    }

    @GetMapping("/comptes/{numCompte}/{type}")
    ResponseEntity<?> findCompte(@PathVariable("numCompte") String numCompte, @PathVariable("type") String type) {
          if(type.equals("CC"))
              return ResponseEntity.ok(findCompteCourant(numCompte));
          if (type.equals("CE"))
              return ResponseEntity.ok(findCompteEpargne(numCompte));
          return null;

    }
}

