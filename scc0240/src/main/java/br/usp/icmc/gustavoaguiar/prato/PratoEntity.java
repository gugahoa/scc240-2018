package br.usp.icmc.gustavoaguiar.prato;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class PratoEntity extends AbstractEntity {
    private String cardapio;
    private String refeicao;

    public String getCardapio() {
        return cardapio;
    }

    public void setCardapio(String cardapio) {
        this.cardapio = cardapio;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    @Override
    public String toString() {
        return "PratoEntity{" + "cardapio='" + cardapio + '\'' + ", refeicao='" + refeicao + '\'' + '}';
    }
}
