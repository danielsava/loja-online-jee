package dao;

import models.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AutorDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Autor> listar() {
        return manager.createQuery("select a from Autor a", Autor.class).getResultList();
    }

}
