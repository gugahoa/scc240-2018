package br.usp.icmc.gustavoaguiar.empresa.mesa;

import br.usp.icmc.gustavoaguiar.terceirizados.TerceirizadosEntity;

public class EmpresaMesaEntity extends TerceirizadosEntity {
    @Override
    public String getTipo() {
        return "LM";
    }
}
