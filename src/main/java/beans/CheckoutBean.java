package beans;

import dao.UsuarioDao;
import models.CarrinhoCompras;
import models.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;

@Model
public class CheckoutBean implements Serializable {

    @Inject
    private CarrinhoCompras carrinho;

    private Usuario usuario;


    @PostConstruct
    private void init() {
        initFormulario();
    }

    private void initFormulario() {
        usuario = new Usuario();
    }

    public void finalizar() {
        carrinho.finalizar(usuario);
        initFormulario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
