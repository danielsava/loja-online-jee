package beans;

import dao.LivroDao;
import models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class LivroDetalheBean {

    @Inject
    private LivroDao livroDao;

    private Integer idLivro;

    private Livro livro;


    public void carregarDetalhe() {
        livro = livroDao.buscarPorId(idLivro);
    }


    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

}
