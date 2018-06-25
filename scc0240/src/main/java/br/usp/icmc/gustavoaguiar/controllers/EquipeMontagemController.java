package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.equipe.montagem.EquipeMontagemEntity;
import br.usp.icmc.gustavoaguiar.equipe.montagem.EquipeMontagemService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/equipe_montagem")
public class EquipeMontagemController {
    @Autowired
    private EquipeMontagemService equipeMontagemService;

    @GetMapping("/{cnpj}")
    public EquipeMontagemEntity get(@PathVariable("cnpj") String cnpj) {
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
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody EquipeMontagemEntity equipeMontagemEntity) {
        equipeMontagemEntity.setCnpj(cnpj);
        if (!equipeMontagemService.update(equipeMontagemEntity)) {
            throw new ResourceNotFound("Equipe de Animacao not found");
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody EquipeMontagemEntity equipeMontagemEntity) {
        EquipeMontagemEntity result = equipeMontagemService.create(equipeMontagemEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }
}
