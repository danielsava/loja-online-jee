package beans;

import dao.LivroDao;
import models.Livro;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model // @|Model é a junção do @Named com o @RequestScoped
public class AdminListaLivrosBean {

    @Inject
    private LivroDao livroDao;

    private List<Livro> livros;

    @PostConstruct
    private void init() {
        livros = livroDao.listar();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
