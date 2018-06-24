package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.decorador.DecoradorEntity;
import br.usp.icmc.gustavoaguiar.decorador.DecoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/decorador")
public class DecoradorController {
    @Autowired
    private DecoradorService decoradorService;

    @PostMapping
    public ResponseEntity post(@RequestBody DecoradorEntity decoradorEntity) {
        DecoradorEntity result = decoradorService.create(decoradorEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }

    @GetMapping("/{cnpj}")
    public DecoradorEntity get(@PathVariable("cnpj") String cnpj) {
        return decoradorService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!decoradorService.delete(cnpj)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity put(@PathVariable("cnpj") String cnpj, @RequestBody DecoradorEntity decoradorEntity) {
        decoradorEntity.setCnpj(cnpj);
        if (!decoradorService.update(decoradorEntity)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }
}
