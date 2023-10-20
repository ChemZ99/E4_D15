package Exercises;

import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("E4_D14");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO ed = new EventoDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO pad = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);

        Supplier<PartitaDiCalcio> partitaDiCalcioSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new PartitaDiCalcio(faker.esports().game(),LocalDate.now(),faker.lorem().paragraph(),TipoEvento.PUBLIC, rndm.nextInt(0,1000),new HashSet<Partecipazione>(),new Location(),faker.esports().team(),faker.esports().team(),"undefined", rndm.nextInt(0,100), rndm.nextInt(0,100));
        };

        Supplier<GaraDiAtletica> garaDiAtleticaSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new GaraDiAtletica(faker.esports().game(),LocalDate.now(),faker.lorem().paragraph(),TipoEvento.PUBLIC, rndm.nextInt(0,1000),new HashSet<Partecipazione>(),new Location(),new HashSet<Persona>(), new Persona());
        };

        Supplier<Concerto> concertoSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Concerto(faker.esports().game(),LocalDate.now(),faker.lorem().paragraph(),TipoEvento.PUBLIC, rndm.nextInt(0,1000),new HashSet<Partecipazione>(),new Location(),Genere.CLASSICO,false);
        };

        Supplier<Persona> personaSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Persona(faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),LocalDate.now(),Sesso.MALE);
        };

        Supplier<Location> locationSupplier = () -> {
            Faker faker = new Faker(Locale.ITALY);
            Random rndm = new Random();
            return new Location(faker.address().country(),faker.address().city(),new ArrayList<Evento>());
        };

        PartitaDiCalcio pc1 = partitaDiCalcioSupplier.get();
        GaraDiAtletica g1 = garaDiAtleticaSupplier.get();
        Concerto c1 = concertoSupplier.get();
        Persona p1 = personaSupplier.get();
        Location l1 = locationSupplier.get();

        try {

            ed.saveEvent(pc1);
            ed.saveEvent(g1);
            ed.saveEvent(c1);
            pd.savePerson(p1);
            ld.saveLocation(l1);

        }catch (Exception ex) {
            System.err.println("Exception" + ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
