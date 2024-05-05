package progetto.dao;

import progetto.entity.Prodotto;
import progetto.entity.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDao {
    private EntityManager em;

    public UtenteDao(EntityManager em){
        this.em = em;
    }

    public void save(Utente utente){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(utente);
        et.commit();
    }

    public Utente getByNumeroTessera(int numeroTessera){
        return em.find(Utente.class, numeroTessera);
    }

    public void delete(int numeroTessera){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Utente utente = getByNumeroTessera(numeroTessera);

        if(utente!=null){
            em.remove(utente);
        } else {
            System.out.println("Utente non presente");
        }

        et.commit();
    }
}
