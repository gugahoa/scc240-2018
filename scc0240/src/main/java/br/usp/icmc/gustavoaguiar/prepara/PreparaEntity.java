package br.usp.icmc.gustavoaguiar.prepara;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class PreparaEntity extends AbstractEntity {
    private String refeicao;
    private String equipe;

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "PreparaEntity{" + "refeicao='" + refeicao + '\'' + ", equipe='" + equipe + '\'' + '}';
    }
}
