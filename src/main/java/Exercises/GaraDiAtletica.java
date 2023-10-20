package Exercises;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento{
    @Column
    @OneToMany(mappedBy = "persona")
    private Set<Persona> atleti = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona vincitore;
    public GaraDiAtletica () {}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                "} " + super.toString();
    }
}
