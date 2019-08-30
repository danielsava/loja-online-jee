package dao;

import models.Livro;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;


public class LivroDao implements Serializable {


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


    public void limparCache() {

        /* Cache da JPA */
        Cache cache = manager.getEntityManagerFactory().getCache();
        cache.evict(Livro.class);
        //cache.evictAll(); // Limpa o cache


        /* O SessionFactory do Hibernate possui mais recursos de administração do cache */
        SessionFactory factory = manager.getEntityManagerFactory().unwrap(SessionFactory.class);

        // factory.getCache().evictAllRegions(); // Limpa o cache inteiro

        factory.getCache().evictQueryRegion("home"); // Limpa o cache de uma região especifica, neste caso limpa o cache da 'home'. As regiões são definidas nas Query através das 'Hint'.




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
                .setHint(QueryHints.HINT_CACHEABLE, true)
                .getResultList();
    }

    public List<Livro> ultimosLancamentos() {

        return manager
                .createQuery("select l from Livro l order by l.dataPublicacao desc", Livro.class)
                .setMaxResults(5)
                .setHint(QueryHints.HINT_CACHEABLE, true)
                .setHint(QueryHints.HINT_CACHE_REGION, "home")
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