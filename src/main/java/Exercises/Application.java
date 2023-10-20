package Exercises;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E4_D15");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        ReadableDAO rd = new ReadableDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

        Utente u1 = new Utente("john","snow", LocalDate.of(1998, Month.NOVEMBER,22),9911);
        Book b1 = new Book(001,"a song of ice and fire",LocalDate.of(2002,Month.JULY,18),765,"George R.R. Martin","Fantasy");
        Magazine m1 = new Magazine(101,"PlayBoy",LocalDate.of(2020,Month.APRIL,12),45,Period.MONTHLY);
        Prestito p1 = new Prestito(LocalDate.of(2020,Month.JULY,12),LocalDate.now(),u1,b1);

        try {
            //rd.saveReadable(b1);
            //rd.saveReadable(m1);
            //ud.saveUser(u1);
            //pd.saveLoan(p1);
            System.out.println("*********************************ricerca per isbn*********************************");
            System.out.println(rd.getReadablebyId(1).toString());
            System.out.println("*********************************ricerca per pubblicazione*********************************");
            System.out.println(rd.getReadablesbyPublish(LocalDate.of(2002,Month.APRIL,12)).toString());
            System.out.println("*********************************ricerca per autore*********************************");
            System.out.println(rd.getReadablesbyAuthor("Row"));
            System.out.println("*********************************ricerca per titolo*********************************");
            System.out.println(rd.getReadablesbyTitle("song"));
            System.out.println("*********************************ricerca elementi in prestito*********************************");
            System.out.println("*********************************ricerca prestiti scaduti*********************************");
            System.out.println(pd.getUnreturnedBooks());

        } catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
