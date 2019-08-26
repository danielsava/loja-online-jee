package beans;

import models.Usuario;

import javax.enterprise.inject.Model;
import java.io.Serializable;

@Model
public class CheckoutBean implements Serializable {

    private Usuario usuario;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
