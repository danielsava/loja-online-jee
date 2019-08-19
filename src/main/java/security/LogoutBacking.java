package security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBacking {


    public String submit() {

        // Invalida Sessão
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        // Redireciona para a página de login
        return "/login.xhtml?faces-redirect=true";

    }


}
