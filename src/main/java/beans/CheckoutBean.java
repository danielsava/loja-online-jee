package beans;

import models.CarrinhoCompras;
import models.Compra;
import models.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@Model
public class CheckoutBean implements Serializable {

    @Inject
    private CarrinhoCompras carrinho;

    @Inject
    private FacesContext facesContext;

    private Usuario usuario;


    @PostConstruct
    private void init() {
        initFormulario();
    }

    private void initFormulario() {
        usuario = new Usuario();
    }

    public void finalizar() {

        Compra compra = new Compra();
        compra.setUsuario(usuario);

        carrinho.finalizar(compra);

        String contextName = facesContext.getExternalContext().getRequestContextPath();

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        response.setHeader("Location",contextName + "/service/pagamento?uuid=" + compra.getUuid());

        initFormulario();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
