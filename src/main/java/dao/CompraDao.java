package dao;

import models.Compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;


public class CompraDao implements Serializable {


    @PersistenceContext
    private EntityManager manager;


    @Transactional
    public void salvar(Compra compra) {
        manager.persist(compra);
    }


}
