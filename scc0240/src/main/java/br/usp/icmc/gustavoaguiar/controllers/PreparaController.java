package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import br.usp.icmc.gustavoaguiar.prepara.PreparaEntity;
import br.usp.icmc.gustavoaguiar.prepara.PreparaService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/prepara")
public class PreparaController {
    @Autowired
    private PreparaService preparaService;

    @PostMapping
    public ResponseEntity create(@RequestBody PreparaEntity preparaEntity) {
        PreparaEntity result = preparaService.create(preparaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{equipe}/{refeicao}").buildAndExpand(ImmutableMap.of("equipe", result.getEquipe(), "refeicao", result.getRefeicao())).toUri()).build();
    }

    @DeleteMapping("/{equipe}/{refeicao}")
    public ResponseEntity delete(@PathVariable("equipe") String equipe, @PathVariable("reficao") String refeicao) {
        if (!preparaService.delete(equipe, refeicao)) {
            throw new ResourceNotFound("Prepara not found");
        }

        return ResponseEntity.ok().build();
    }
}
