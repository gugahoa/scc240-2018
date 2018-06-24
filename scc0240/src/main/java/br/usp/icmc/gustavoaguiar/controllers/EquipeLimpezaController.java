package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.equipe.limpeza.EquipeLimpezaEntity;
import br.usp.icmc.gustavoaguiar.equipe.limpeza.EquipeLimpezaService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Timestamp;

@RestController
@RequestMapping("/equipe_limpeza")
public class EquipeLimpezaController {
    @Autowired
    private EquipeLimpezaService equipeLimpezaService;

    @GetMapping("/{cnpj}")
    public EquipeLimpezaEntity get(@PathVariable("cnpj") String cnpj) {
        return equipeLimpezaService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!equipeLimpezaService.delete(cnpj)) {
            throw new ResourceNotFound("Equipe de Limpeza not found");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody EquipeLimpezaEntity equipeLimpezaEntity) {
        equipeLimpezaEntity.setCnpj(cnpj);
        if (!equipeLimpezaService.update(equipeLimpezaEntity)) {
            throw new ResourceNotFound("Equipe de Limpeza not found");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody EquipeLimpezaEntity equipeLimpezaEntity) {
        EquipeLimpezaEntity result = equipeLimpezaService.create(equipeLimpezaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }

    @PostMapping("/{cnpj}/clean/{festa}")
    public ResponseEntity clean(@PathVariable("cnpj") String cnpj, @PathVariable("festa") Timestamp festa) {
        if (!equipeLimpezaService.clean(festa, cnpj)) {
            throw new ResourceNotFound("Equipe de Limpeza or Festa not found");
        }

        return ResponseEntity.ok().build();
    }
}
