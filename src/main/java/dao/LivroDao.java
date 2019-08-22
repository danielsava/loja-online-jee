package dao;

import models.Livro;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public class LivroDao {


    private static Integer criado = 0;
    private static Integer construido = 0;
    private static Integer destruido = 0;


    @PersistenceContext
    private EntityManager manager;


    public LivroDao() {
        System.out.println("#### LivroDao Construtor: " + ++criado);
    }

    @PostConstruct
    private void init() {
        System.out.println("**** LivroDao Criado: " + ++construido);
    }

    @PreDestroy
    private void destroy() {
        System.out.println("++++ LivroDao Destruido: " + ++destruido);
    }

    @Transactional
    public void salvar(Livro livro) {
        //manager.getTransaction().begin();
        manager.persist(livro);
        //manager.getTransaction().commit();
    }

    public List<Livro> listar() {
        return manager
                .createQuery("select distinct (l) from Livro l join fetch l.autores", Livro.class)
                .getResultList();
    }

    public List<Livro> ultimosLancamentos() {
        return manager
                .createQuery("select l from Livro l order by l.dataPublicacao desc", Livro.class)
                .setMaxResults(5)
                .getResultList();

    }

    public Livro buscarPorId(Integer idLivro) {
        return manager
                .createQuery("select l from Livro l join fetch l.autores where l.id=:id ", Livro.class)
                .setParameter("id", idLivro)
                .getSingleResult()
                ;
    }

}