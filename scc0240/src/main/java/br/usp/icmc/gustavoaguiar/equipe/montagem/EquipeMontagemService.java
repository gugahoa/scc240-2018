package br.usp.icmc.gustavoaguiar.equipe.montagem;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

@Service
public class EquipeMontagemService extends BaseTerceirizadosService<EquipeMontagemEntity, EquipeMontagemRepository> {
    public EquipeMontagemService(EquipeMontagemRepository genericRepository) {
        super(genericRepository);
    }
}
