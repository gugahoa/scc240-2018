package br.usp.icmc.gustavoaguiar.refeicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefeicaoService {
    @Autowired
    private RefeicaoRepository refeicaoRepository;

    public RefeicaoEntity create(RefeicaoEntity refeicaoEntity) {
        return refeicaoRepository.create(refeicaoEntity);
    }

    public RefeicaoEntity get(String nome) {
        return refeicaoRepository.get(nome);
    }

    public boolean delete(String nome) {
        return refeicaoRepository.delete(nome);
    }
}
