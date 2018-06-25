package br.usp.icmc.gustavoaguiar.cardapio;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class CardapioEntity extends AbstractEntity {
    private String nome;

    @Override
    public String toString() {
        return "CardapioEntity{" + "nome='" + nome + '\'' + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
