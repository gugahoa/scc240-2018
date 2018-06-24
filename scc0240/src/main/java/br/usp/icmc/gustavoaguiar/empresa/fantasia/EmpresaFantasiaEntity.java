package br.usp.icmc.gustavoaguiar.empresa.fantasia;

import br.usp.icmc.gustavoaguiar.terceirizados.TerceirizadosEntity;

public class EmpresaFantasiaEntity extends TerceirizadosEntity {
    @Override
    public String getTipo() {
        return "EF";
    }
}
