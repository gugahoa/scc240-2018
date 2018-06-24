package br.usp.icmc.gustavoaguiar.equipe.animacao;

import br.usp.icmc.gustavoaguiar.library.BaseTerceirizadosService;
import org.springframework.stereotype.Service;

@Service
public class EquipeAnimacaoService extends BaseTerceirizadosService<EquipeAnimacaoEntity, EquipeAnimacaoRepository> {
    public EquipeAnimacaoService(EquipeAnimacaoRepository genericRepository) {
        super(genericRepository);
    }
}
