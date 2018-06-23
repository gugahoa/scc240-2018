package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.convite.ConviteEntity;
import br.usp.icmc.gustavoaguiar.convite.ConviteService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/convite")
public class ConviteController {
    @Autowired
    private ConviteService conviteService;

    @GetMapping("/{qrcode}")
    public ConviteEntity get(@PathVariable("qrcode") Long qrcode) {
        ConviteEntity entity = conviteService.get(qrcode);
        if (entity == null) {
            throw new ResourceNotFound("Convite not found");
        }
        return entity;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ConviteEntity conviteEntity) {
        ConviteEntity result = conviteService.create(conviteEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getQrcode()).toUri()).build();
    }

    @DeleteMapping("/{qrcode}")
    public ResponseEntity delete(@PathVariable("qrcode") Long qrcode) {
        if (!conviteService.delete(qrcode)) {
            throw new ResourceNotFound("Convite not found");
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{qrcode}")
    public  ResponseEntity update(@PathVariable("qrcode") Long qrcode, @RequestBody ConviteEntity conviteEntity) {
        if (conviteService.get(qrcode) == null) {
            throw new ResourceNotFound("Convite not found");
        }

        conviteEntity.setQrcode(qrcode);
        if (!conviteService.update(conviteEntity)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }
}
