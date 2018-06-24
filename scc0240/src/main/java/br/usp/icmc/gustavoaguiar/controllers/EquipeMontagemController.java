package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoEntity;
import br.usp.icmc.gustavoaguiar.equipe.animacao.EquipeAnimacaoService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/equipe_montagem")
public class EquipeMontagemController {
    @Autowired
    private EquipeAnimacaoService equipeMontagemService;

    @GetMapping("/{cnpj}")
    public EquipeAnimacaoEntity get(@PathVariable("cnpj") String cnpj) {
        return equipeMontagemService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!equipeMontagemService.delete(cnpj)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody EquipeAnimacaoEntity equipeMontagemEntity) {
        equipeMontagemEntity.setCnpj(cnpj);
        if (!equipeMontagemService.update(equipeMontagemEntity)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody EquipeAnimacaoEntity equipeMontagemEntity) {
        EquipeAnimacaoEntity result = equipeMontagemService.create(equipeMontagemEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }
}
