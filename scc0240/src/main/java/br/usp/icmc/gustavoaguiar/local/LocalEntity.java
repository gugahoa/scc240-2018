package br.usp.icmc.gustavoaguiar.local;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

public class LocalEntity extends AbstractEntity {
    private String endereco;
    private boolean comprovante;
    private Integer custo;
    private Integer lotacao;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getComprovante() {
        return comprovante;
    }

    public void setComprovante(boolean comprovante) {
        this.comprovante = comprovante;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public String toString() {
        return "LocalEntity{" + "endereco='" + endereco + '\'' + ", comprovante=" + comprovante + ", custo=" + custo + ", lotacao=" + lotacao + '}';
    }
}
