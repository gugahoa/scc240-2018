package br.usp.icmc.gustavoaguiar.equipe.cozinha;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

@Service
public class EquipeCozinhaService extends BaseTerceirizadosService<EquipeCozinhaEntity, EquipeCozinhaRepository> {
    public EquipeCozinhaService(EquipeCozinhaRepository genericRepository) {
        super(genericRepository);
    }
}
