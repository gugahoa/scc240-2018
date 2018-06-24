package br.usp.icmc.gustavoaguiar.equipe.montagem;

import br.usp.icmc.gustavoaguiar.terceirizados.TerceirizadosEntity;

public class EquipeMontagemEntity extends TerceirizadosEntity {
    @Override
    public String getTipo() {
        return "EM";
    }
}
