package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoEntity;
import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/equipe_animacao")
public class EquipeAnimacaoController {
    @Autowired
    private EquipeAnimacaoService equipeAnimacaoService;

    @GetMapping("/{cnpj}")
    public EquipeAnimacaoEntity get(@PathVariable("cnpj") String cnpj) {
        return equipeAnimacaoService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!equipeAnimacaoService.delete(cnpj)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody EquipeAnimacaoEntity equipeAnimacaoEntity) {
        equipeAnimacaoEntity.setCnpj(cnpj);
        if (!equipeAnimacaoService.update(equipeAnimacaoEntity)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody EquipeAnimacaoEntity equipeAnimacaoEntity) {
        EquipeAnimacaoEntity result = equipeAnimacaoService.create(equipeAnimacaoEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }
}
