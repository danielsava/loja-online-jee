package beans;

import dao.AutorDao;
import dao.LivroDao;
import models.Autor;
import models.Livro;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable  {

    @Inject
    private LivroDao livroDao;

    @Inject
    private AutorDao autorDao;

    @Inject
    private FacesContext facesContext;

    private Livro livro;

    private List<Autor> autores;

    private Part capaLivro;

    @PostConstruct
    private void init() {
        limparForm();
    }

    private void limparForm() {
        livro = new Livro();

        autores = autorDao.listar();
        if (autores == null)
            autores = new ArrayList<>();

    }

    public String salvar() {

        livroDao.salvar(livro);

        mostrarMensagem("Livro Cadastrado com Sucesso");

        limparForm();

        return "/livros/lista?faces-redirect=true";

    }

    private void mostrarMensagem(String msg) {

        // O escopo de Flash dura entre 2 request´s. O JSF armazena na sessão do usuário, e no último request (2º request)
        // ele serpa removido.
        facesContext.getExternalContext().getFlash().setKeepMessages(true);

        // Por causa do escopo Flash ativado pra mensagens, essa mensagem irá aparecer depois do redirecionamento do salvar.
        facesContext.addMessage(null, new FacesMessage(msg));
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Part getCapaLivro() {
        return capaLivro;
    }

    public void setCapaLivro(Part capaLivro) {
        this.capaLivro = capaLivro;
    }

}
