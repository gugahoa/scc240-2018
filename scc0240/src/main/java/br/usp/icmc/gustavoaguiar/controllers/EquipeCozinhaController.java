package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoEntity;
import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/equipe_cozinha")
public class EquipeCozinhaController {
    @Autowired
    private EquipeAnimacaoService equipeCozinhaService;

    @GetMapping("/{cnpj}")
    public EquipeAnimacaoEntity get(@PathVariable("cnpj") String cnpj) {
        return equipeCozinhaService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!equipeCozinhaService.delete(cnpj)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody EquipeAnimacaoEntity equipeCozinhaEntity) {
        equipeCozinhaEntity.setCnpj(cnpj);
        if (!equipeCozinhaService.update(equipeCozinhaEntity)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody EquipeAnimacaoEntity equipeCozinhaEntity) {
        EquipeAnimacaoEntity result = equipeCozinhaService.create(equipeCozinhaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }
}
