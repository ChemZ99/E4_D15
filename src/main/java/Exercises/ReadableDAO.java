package Exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

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

    public List<Readable> getReadablesbyPublish (LocalDate year){
        int cond = year.getYear();
        try {
            TypedQuery<Readable> q = em.createQuery("SELECT x FROM Book x, Magazine xx WHERE (EXTRACT (ISOYEAR FROM x.published) = :cond) OR (EXTRACT (ISOYEAR FROM xx.published) = :cond)", Readable.class);
            q.setParameter("cond", cond);
            return q.getResultList();
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
            throw ex;
        }
    }

    public List<Book> getReadablesbyAuthor (String author){
        try {
            TypedQuery<Book> q = em.createQuery("SELECT x FROM Book x WHERE x.author LIKE CONCAT ('%', :cond, '%')", Book.class);
            q.setParameter("cond", author);
            return q.getResultList();
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
            throw ex;
        }
    }

    public List<Readable> getReadablesbyTitle (String title){
        try {
            TypedQuery<Readable> q = em.createQuery("SELECT x FROM Book x, Magazine xx WHERE (x.title LIKE CONCAT ('%', :cond, '%')) OR (xx.title LIKE CONCAT ('%', :cond, '%'))", Readable.class);
            q.setParameter("cond", title);
            return q.getResultList();
        } catch (Exception ex) {
            System.err.println("exception" + ex.getMessage());
            throw ex;
        }
    }

}
