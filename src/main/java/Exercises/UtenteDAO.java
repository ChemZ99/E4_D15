package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em){this.em = em;}

    public void saveUser (Utente ut) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(ut);
            transaction.commit();
            System.out.println("user saved");
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
        }
    }

    public Utente getUserbyId (long id) {
        return em.find(Utente.class, id);
    }

    public void deleteUserbyId (long id) {
        try {
            Utente target = em.find(Utente.class, id);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("user deleted");
            } else {
                System.out.println("no user found");
            }
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());

        }
    }
}
