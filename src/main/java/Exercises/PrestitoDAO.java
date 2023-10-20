package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em){this.em = em;}

    public void saveLoan (Prestito pr) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(pr);
            transaction.commit();
            System.out.println("loan saved");
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
        }
    }

    public Prestito getLoanbyId (long id) {
        return em.find(Prestito.class, id);
    }

    public void deleteLoanbyId (long id) {
        try {
            Prestito target = em.find(Prestito.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("loan deleted");
            } else {
                System.out.println("no loan found");
            }
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());

        }
    }

    public List<Prestito> getUnreturnedBooks (){
        try {
            TypedQuery<Prestito> q = em.createQuery("SELECT x FROM Prestito x WHERE x.consegnaEffettiva > x.consegnaPrevista", Prestito.class);
            return q.getResultList();
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
            throw ex;
        }
    }
}
