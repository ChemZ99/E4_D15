package Exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Concerto extends Evento{
    @Enumerated
    @Column
    private Genere genere;
    @Column
    private boolean inStreaming;
    public Concerto () {}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
