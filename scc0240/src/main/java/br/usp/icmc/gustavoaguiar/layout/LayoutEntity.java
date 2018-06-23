package br.usp.icmc.gustavoaguiar.layout;

import br.usp.icmc.gustavoaguiar.library.AbstractEntity;

import java.util.Arrays;

public class LayoutEntity extends AbstractEntity {
    private String tipo;
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "LayoutEntity{" + "tipo='" + tipo + '\'' + ", image=" + Arrays.toString(image) + '}';
    }
}
