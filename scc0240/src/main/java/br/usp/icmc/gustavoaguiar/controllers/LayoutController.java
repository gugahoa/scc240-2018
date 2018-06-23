package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.layout.LayoutEntity;
import br.usp.icmc.gustavoaguiar.layout.LayoutService;
import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("/layout")
public class LayoutController {
    @Autowired
    private LayoutService layoutService;

    @PostMapping
    public ResponseEntity create(@RequestParam("image") MultipartFile image, @RequestParam("tipo") String tipo) throws IOException {
        LayoutEntity layoutEntity = new LayoutEntity();
        layoutEntity.setImage(image.getBytes());
        layoutEntity.setTipo(tipo);

        LayoutEntity result = layoutService.create(layoutEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getTipo()).toUri()).build();
    }

    @GetMapping("/{tipo}")
    public LayoutEntity get(@PathVariable("tipo") String tipo) {
        LayoutEntity layoutEntity = layoutService.get(tipo);
        if (layoutEntity == null) {
            throw new ResourceNotFound("Layout not found");
        }

        return layoutEntity;
    }

    @DeleteMapping("/{tipo}")
    public ResponseEntity delete(@PathVariable("tipo") String tipo) {
        if (!layoutService.delete(tipo)) {
            throw new ResourceNotFound("Layout not found");
        }

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{tipo}")
    public ResponseEntity update(@PathVariable("tipo") String tipo, @RequestParam("image") MultipartFile image) throws IOException {
        LayoutEntity layoutEntity = layoutService.get(tipo);
        if (layoutEntity == null) {
            throw new ResourceNotFound("Layout not found");
        }

        layoutEntity.setImage(image.getBytes());
        if (!layoutService.update(layoutEntity)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok().build();
    }
}
