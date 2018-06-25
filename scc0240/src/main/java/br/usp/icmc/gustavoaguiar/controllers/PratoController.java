package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import br.usp.icmc.gustavoaguiar.prato.PratoEntity;
import br.usp.icmc.gustavoaguiar.prato.PratoService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/prato")
public class PratoController {
    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity post(@RequestBody PratoEntity pratoEntity) {
        PratoEntity result = pratoService.create(pratoEntity);
        return ResponseEntity .created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{cardapio}/{refeicao}").buildAndExpand(ImmutableMap.of("cardapio", result.getCardapio(), "refeicao", result.getRefeicao())).toUri()).build();
    }

    @GetMapping("/{cardapio}/{refeicao}")
    public PratoEntity get(@PathVariable("cardapio") String cardapio, @PathVariable("refeicao") String refeicao) {
        return pratoService.get(cardapio, refeicao);
    }

    @DeleteMapping("/{cardapio}/{refeicao}")
    public ResponseEntity delete(@PathVariable("cardapio") String cardapio, @PathVariable("refeicao") String refeicao) {
        if (!pratoService.delete(cardapio, refeicao)) {
            throw new ResourceNotFound("Prato not found");
        }

        return ResponseEntity.ok().build();
    }
}
