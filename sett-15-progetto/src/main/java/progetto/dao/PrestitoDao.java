package progetto.dao;

import progetto.entity.Prestito;
import progetto.entity.Prodotto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PrestitoDao {
    private EntityManager em;

    public PrestitoDao(EntityManager em){
        this.em = em;
    }

    public void save(Prestito prestito){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getByPrestitoId(int prestitoId){
        return em.find(Prestito.class, prestitoId);
    }

    public void delete(int prestitoId){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito prestito = getByPrestitoId(prestitoId);

        if(prestito!=null){
            em.remove(prestito);
        } else {
            System.out.println("Prestito non presente");
        }

        et.commit();
    }
    public Prodotto getProdottoByNumTessera (int numeroTessera){
        Query query = em.createQuery("select p.prodotto from Prestito p where p.utente.numeroTessera=:numeroTessera");
        query.setParameter("numeroTessera", numeroTessera);
        return (Prodotto) query.getResultList();
    }
}
