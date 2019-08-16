package beans;

import dao.AutorDao;
import dao.LivroDao;
import models.Autor;
import models.Livro;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AdminLivrosBean {

    @Inject
    private LivroDao livroDao;

    @Inject
    private AutorDao autorDao;

    private Livro livro;

    private List<Autor> autores;

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

    public void salvar() {
        livroDao.salvar(livro);
        System.out.println("Livro Cadastrado: " + livro);
        limparForm();
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

}
