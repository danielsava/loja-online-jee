package dao;

import models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

public class UsuarioDao implements Serializable {

    @PersistenceContext
    private EntityManager manager;


    @Transactional
    public void salvar(Usuario usuario) {
        manager.persist(usuario);

    }


}
