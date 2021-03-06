package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.banda.BandaEntity;
import br.usp.icmc.gustavoaguiar.banda.BandaService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/bandas")
public class BandaController {
    @Autowired
    private BandaService bandaService;

    @PostMapping
    public ResponseEntity create(@RequestBody BandaEntity bandaEntity) {
        BandaEntity result = bandaService.create(bandaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(result.getNome()).toUri()).build();
    }

    @GetMapping("/{nome}")
    public BandaEntity get(@PathVariable("nome") String nome) {
        return bandaService.get(nome);
    }

    @PutMapping("/{nome}")
    public ResponseEntity update(@PathVariable("nome") String nome, @RequestBody BandaEntity bandaEntity) {
        bandaEntity.setNome(nome);
        if (!bandaService.update(bandaEntity)) {
            throw new ResourceNotFound("Banda not found");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity delete(@PathVariable("nome") String nome) {
        if (!bandaService.delete(nome)) {
            throw new ResourceNotFound("Banda not found");
        }
        return ResponseEntity.ok().build();
    }
}
