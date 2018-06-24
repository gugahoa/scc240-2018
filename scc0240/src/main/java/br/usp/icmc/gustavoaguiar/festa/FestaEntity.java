package br.usp.icmc.gustavoaguiar.festa;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

import java.sql.Timestamp;

public class FestaEntity extends AbstractEntity {
    private Timestamp data;
    private String tipo;
    private String local;
    private String decorador;

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDecorador() {
        return decorador;
    }

    public void setDecorador(String decorador) {
        this.decorador = decorador;
    }

    @Override
    public String toString() {
        return "FestaEntity{" + "data=" + data + ", tipo='" + tipo + '\'' + ", local='" + local + '\'' + ", decorador='" + decorador + '\'' + '}';
    }
}
