package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.empresa.mesa.EmpresaMesaEntity;
import br.usp.icmc.gustavoaguiar.empresa.mesa.EmpresaMesaService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Time;
import java.sql.Timestamp;

@RestController
@RequestMapping("/empresa_mesa")
public class EmpresaMesaController {
    @Autowired
    private EmpresaMesaService empresaMesaService;

    @PostMapping
    public ResponseEntity post(@RequestBody EmpresaMesaEntity empresaMesaEntity) {
        EmpresaMesaEntity result = empresaMesaService.create(empresaMesaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }

    @PostMapping("/{cnpj}/create_mesa")
    public ResponseEntity create_mesa(@PathVariable("cnpj") String cnpj) {
        if (!empresaMesaService.create_mesa(cnpj)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/alocar/{data}/{mesas}")
    public ResponseEntity allocate_mesas(@PathVariable("data") Timestamp festa, @PathVariable("mesas") Long mesas) {
        int mesas_alocadas = empresaMesaService.allocate_mesas(festa, mesas);
        if (mesas_alocadas == 0) {
            throw new ResourceNotFound("Not enough mesas available");
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/alocar/{data}")
    public ResponseEntity delete_mesas(@PathVariable("data") Timestamp festa) {
        if (!empresaMesaService.delete_possui_mesa(festa)) {
            throw new ResourceNotFound("Mesas allocated for Festa not found");
        }

        return ResponseEntity.ok().build();
    }
}
