package br.usp.icmc.gustavoaguiar.decorador;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class DecoradorEntity  extends AbstractEntity {
    private String cnpj;
    private String contato;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "DecoradorEntity{" + "cnpj='" + cnpj + '\'' + ", contato='" + contato + '\'' + '}';
    }
}
