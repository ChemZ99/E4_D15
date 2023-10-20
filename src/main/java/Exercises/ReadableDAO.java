package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ReadableDAO {
    private final EntityManager em;

    public ReadableDAO(EntityManager em){this.em = em;}

    public void saveReadable (Readable re) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(re);
            transaction.commit();
            System.out.println("readable saved");
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
        }
    }

    public Readable getReadablebyId (int isbn) {
            return em.find(Readable.class, isbn);
    }

    public void deleteReadablebyId (int isbn) {
        try {
            Readable target = em.find(Readable.class, isbn);
            if (target != null) {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(target);
                transaction.commit();
                System.out.println("readable deleted");
            } else {
                System.out.println("no readable found");
            }
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());

        }
    }
}
