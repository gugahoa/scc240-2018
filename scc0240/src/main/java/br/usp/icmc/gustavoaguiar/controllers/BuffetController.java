package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.buffet.BuffetEntity;
import br.usp.icmc.gustavoaguiar.buffet.BuffetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.sql.Timestamp;

@RestController
@RequestMapping("/buffet")
public class BuffetController {
    @Autowired
    private BuffetService buffetService;

    @PostMapping
    public ResponseEntity post(@RequestBody BuffetEntity buffetEntity) {
        buffetEntity.getData().setTime(buffetEntity.getData().getTime() + (1 * 24 * 60 * 60 * 1000));
        BuffetEntity result = buffetService.create(buffetEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getFesta()).toUri()).build();
    }

    @DeleteMapping("/{data}")
    public ResponseEntity delete(@PathVariable("data") Timestamp data) {
        if (!buffetService.delete(data)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{data}")
    public ResponseEntity put(@PathVariable("data") Timestamp data, @RequestBody BuffetEntity buffetEntity) {
        buffetEntity.setData(data);
        if (!buffetService.update(buffetEntity)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{data}")
    public BuffetEntity get(@PathVariable("data") Timestamp data) {
        return buffetService.get(data);
    }
}
