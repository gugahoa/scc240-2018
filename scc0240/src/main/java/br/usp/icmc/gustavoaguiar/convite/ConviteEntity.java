package br.usp.icmc.gustavoaguiar.convite;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

import java.sql.Timestamp;

public class ConviteEntity extends AbstractEntity {
    private Long qrcode;
    private String dados;
    private String remetente;
    private String layout;
    private Timestamp festa;

    public Timestamp getFesta() {
        return festa;
    }

    public void setFesta(Timestamp festa) {
        this.festa = festa;
    }

    public Long getQrcode() {
        return qrcode;
    }

    public void setQrcode(Long qrcode) {
        this.qrcode = qrcode;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }
}
