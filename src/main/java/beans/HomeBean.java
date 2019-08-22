package beans;

import dao.LivroDao;
import models.Livro;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class HomeBean {


    @Inject
    private LivroDao livroDao;



    public List<Livro> ultimosLancamentos() {
        return livroDao.ultimosLancamentos();
    }

    public List<Livro> todosLivros() {
        return livroDao.listar();
    }


}
