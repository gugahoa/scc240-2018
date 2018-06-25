package br.usp.icmc.gustavoaguiar.prato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PratoService {
    @Autowired
    private PratoRepository pratoRepository;

    public PratoEntity create(PratoEntity pratoEntity) {
        return pratoRepository.create(pratoEntity);
    }

    public PratoEntity get(String cardapio, String refeicao) {
        return pratoRepository.get(cardapio, refeicao);
    }

    public boolean delete(String cardapio, String refeicao) {
        return pratoRepository.delete(cardapio, refeicao);
    }
}
