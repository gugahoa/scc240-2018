package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.convite.ConviteEntity;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import br.usp.icmc.gustavoaguiar.local.LocalEntity;
import br.usp.icmc.gustavoaguiar.local.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/local")
public class LocalController {
    @Autowired
    private LocalService localService;

    @GetMapping("/{endereco}")
    public LocalEntity get(@PathVariable("endereco") String endereco) {
        LocalEntity localEntity = localService.get(endereco);
        if (localEntity == null) {
            throw new ResourceNotFound("Local not found");
        }

        return localEntity;
    }

    @DeleteMapping("/{endereco}")
    public ResponseEntity delete(@PathVariable("endereco") String endereco) {
        if (localService.get(endereco) == null) {
            throw new ResourceNotFound("Local not found");
        }

        if (!localService.delete(endereco)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{endereco}")
    public ResponseEntity put(@PathVariable("endereco") String endereco, @RequestBody LocalEntity localEntity) {
        if (localService.get(endereco) == null) {
            throw new ResourceNotFound("Local not found");
        }

        localEntity.setEndereco(endereco);
        if (!localService.update(localEntity)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody LocalEntity localEntity) {
        LocalEntity result = localService.create(localEntity);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getEndereco()).toUri()).build();
    }
}
