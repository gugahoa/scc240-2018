package br.usp.icmc.gustavoaguiar.buffet;

import br.usp.icmc.gustavoaguiar.festa.FestaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class BuffetEntity extends FestaEntity {
    @JsonIgnore
    private Timestamp festa;
    private String cardapio;

    public Timestamp getFesta() {
        return festa;
    }

    public void setFesta(Timestamp festa) {
        this.festa = festa;
    }

    public String getCardapio() {
        return cardapio;
    }

    public void setCardapio(String cardapio) {
        this.cardapio = cardapio;
    }

    @Override
    public String toString() {
        return "BuffetEntity{" + "festa=" + festa + ", cardapio='" + cardapio + '\'' + ", " + super.toString() + "}";
    }
}
