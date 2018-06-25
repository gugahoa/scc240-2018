package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.cardapio.CardapioEntity;
import br.usp.icmc.gustavoaguiar.cardapio.CardapioService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {
    @Autowired
    private CardapioService cardapioService;

    @PostMapping
    public ResponseEntity post(@RequestBody CardapioEntity cardapioEntity) {
        CardapioEntity result = cardapioService.create(cardapioEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(result.getNome()).toUri()).build();
    }

    @GetMapping("/{nome}")
    public CardapioEntity get(@PathVariable("nome") String nome) {
        return cardapioService.get(nome);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity delete(@PathVariable("nome") String nome) {
        if (!cardapioService.delete(nome))
            throw new ResourceNotFound("Cardapio not found");
        return ResponseEntity.ok().build();
    }
}
