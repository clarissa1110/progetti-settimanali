package progetto.dao;

import progetto.entity.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ProdottoDao {
    private EntityManager em;

    public ProdottoDao(EntityManager em){
        this.em = em;
    }

    public void save(Prodotto prodotto){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prodotto);
        et.commit();
    }

    public Prodotto getProdottoByIsbn(int codiceISBN){
        Query query = em.createQuery("select p from Prodotto p where p.codiceisbn=:codice");
        query.setParameter("codice", codiceISBN);
        return (Prodotto) query.getSingleResult();
    }

    public void delete(int codiceISBN){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prodotto prodotto = getProdottoByIsbn(codiceISBN);

        if(prodotto!=null){
            em.remove(prodotto);
        } else {
            System.out.println("Prodotto non presente");
        }

        et.commit();
    }

    public Prodotto getProdottoByAnno(int annoPubblicazione){
        Query query = em.createQuery("select p from Prodotto p where p.anno_pubblicazione=:anno");
        query.setParameter("anno", annoPubblicazione);
        return (Prodotto) query.getResultList();
    }

    public Prodotto getProdottoByPartTitolo(String titolo){
        Query query = em.createQuery("select p from Prodotto p where p.titolo like :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        return (Prodotto) query.getResultList();
    }
}
