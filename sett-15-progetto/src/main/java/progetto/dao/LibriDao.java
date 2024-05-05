package progetto.dao;

import progetto.entity.Libri;
import progetto.entity.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class LibriDao {
    private EntityManager em;

    public LibriDao(EntityManager em){
        this.em = em;
    }

    public void save(Libri libri){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(libri);
        et.commit();
    }

    public Libri getLibroByAutore(String autore){
        Query query = em.createQuery("select l from Libri l where l.autore=:autore");
        query.setParameter("autore", autore);
        return (Libri) query.getResultList();
    }


}
