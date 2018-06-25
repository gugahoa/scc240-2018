package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import br.usp.icmc.gustavoaguiar.refeicao.RefeicaoEntity;
import br.usp.icmc.gustavoaguiar.refeicao.RefeicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/refeicao")
public class RefeicaoController {
    @Autowired
    private RefeicaoService refeicaoService;

    @PostMapping
    public ResponseEntity create(@RequestBody RefeicaoEntity refeicaoEntity) {
        RefeicaoEntity result = refeicaoService.create(refeicaoEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getNome()).toUri()).build();
    }

    @GetMapping("/{nome}")
    public RefeicaoEntity get(@PathVariable("nome") String nome) {
        return refeicaoService.get(nome);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity delete(@PathVariable("nome") String nome) {
        if (!refeicaoService.delete(nome))
            throw new ResourceNotFound("Refeicao not found");

        return ResponseEntity.ok().build();
    }
}
