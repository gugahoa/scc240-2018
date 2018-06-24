package br.usp.icmc.gustavoaguiar.controllers;

import br.usp.icmc.gustavoaguiar.library.ResourceNotFound;
import br.usp.icmc.gustavoaguiar.empresa.fantasia.EmpresaFantasiaEntity;
import br.usp.icmc.gustavoaguiar.empresa.fantasia.EmpresaFantasiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/empresa_fantasia")
public class EmpresaFantasiaController {
    @Autowired
    private EmpresaFantasiaService empresaFantasiaService;

    @PostMapping
    public ResponseEntity create(@RequestBody EmpresaFantasiaEntity empresaFantasiaEntity) {
        EmpresaFantasiaEntity result = empresaFantasiaService.create(empresaFantasiaEntity);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getCnpj()).toUri()).build();
    }

    @GetMapping("/{cnpj}")
    public EmpresaFantasiaEntity get(@PathVariable("cnpj") String cnpj) {
        return empresaFantasiaService.get(cnpj);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity delete(@PathVariable("cnpj") String cnpj) {
        if (!empresaFantasiaService.delete(cnpj)) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity update(@PathVariable("cnpj") String cnpj, @RequestBody EmpresaFantasiaEntity empresaFantasiaEntity) {
        empresaFantasiaEntity.setCnpj(cnpj);
        if (!empresaFantasiaService.update(empresaFantasiaEntity)) {
            throw new ResourceNotFound("Empresa de Fantasia not found");
        }

        return ResponseEntity.ok().build();
    }
}
