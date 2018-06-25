package br.usp.icmc.gustavoaguiar.banda;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

import java.sql.Array;

public class BandaEntity extends AbstractEntity {
    private String name;
    private String[] integrantes;

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public String[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String[] integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "BandaEntity{" + "name='" + name + '\'' + ", integrantes=" + integrantes + '}';
    }
}
