package dao;

import models.Livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class LivroDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void salvar(Livro livro) {
        //manager.getTransaction().begin();
        manager.persist(livro);
        //manager.getTransaction().commit();
    }

    public List<Livro> listar() {
        return manager.createQuery("select distinct (l) from Livro l join fetch l.autores", Livro.class).getResultList();
    }

}
