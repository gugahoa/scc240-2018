package br.usp.icmc.gustavoaguiar.refeicao;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class RefeicaoEntity extends AbstractEntity {
    private String nome;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "RefeicaoEntity{" + "nome='" + nome + '\'' + ", tipo='" + tipo + '\'' + '}';
    }
}
