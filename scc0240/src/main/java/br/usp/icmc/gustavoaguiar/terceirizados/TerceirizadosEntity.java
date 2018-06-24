package br.usp.icmc.gustavoaguiar.terceirizados;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class TerceirizadosEntity extends AbstractEntity {
    private String cnpj;
    private String contato;
    private String tipo;

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
