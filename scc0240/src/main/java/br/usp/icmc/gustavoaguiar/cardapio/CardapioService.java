package br.usp.icmc.gustavoaguiar.cardapio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository cardapioRepository;

    public CardapioEntity create(CardapioEntity cardapioEntity) {
        return cardapioRepository.create(cardapioEntity);
    }

    public CardapioEntity get(String nome) {
        return cardapioRepository.get(nome);
    }

    public boolean update(CardapioEntity cardapioEntity) {
        return cardapioRepository.update(cardapioEntity);
    }

    public boolean delete(String nome) {
        return cardapioRepository.delete(nome);
    }
}
