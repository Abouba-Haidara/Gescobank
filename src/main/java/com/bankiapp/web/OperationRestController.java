package com.bankiapp.web;

import com.bankiapp.dto.OperationDto;
import com.bankiapp.entities.Operation;
import com.bankiapp.services.OperationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class OperationRestController {
    private final OperationService operationService;
    OperationRestController(final OperationService operationService) {
        this.operationService = operationService ;
    }

    @PostMapping("/versements")
    public void versements(
            @RequestBody OperationDto dto) {
        operationService.effectuerVersement(dto.getNumCompte(), dto.getAmount());
    }

    @PostMapping("/retraits")
    public void retraits(
            @RequestBody OperationDto dto) {
        operationService.effectuerRetrait(dto.getNumCompte(), dto.getAmount());
    }

    @PostMapping("/virements")
    public void virements(
            @RequestBody OperationDto dto) {
        operationService.virementFromOneCompteAToCompteB(dto.getNumCompteS(), dto.getNumCompteD(), dto.getAmount());
    }

    @GetMapping("/operations/client/{numCompte}")
    List<Operation> findAllOperationByClient(@PathVariable("numCompte") String numCompte) {
        return this.operationService.findByClientNumCompte(numCompte);
    }

}
