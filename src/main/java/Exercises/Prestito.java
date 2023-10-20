package Exercises;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private LocalDate inizioPrestito;
    @Column
    private LocalDate consegnaPrevista;
    @Column
    private LocalDate consegnaEffettiva;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    @Column
    private Utente utente;

    @OneToMany(mappedBy = "prestito")
    @Column
    private List<Readable> prestati = new ArrayList<>();

    public Prestito () {}

    public Prestito(LocalDate inizioPrestito, LocalDate consegnaPrevista, LocalDate consegnaEffettiva, Utente utente, List<Readable> prestati) {
        this.inizioPrestito = inizioPrestito;
        this.consegnaPrevista = consegnaPrevista;
        this.consegnaEffettiva = consegnaEffettiva;
        this.utente = utente;
        this.prestati = prestati;
    }

    public LocalDate getInizioPrestito() {
        return inizioPrestito;
    }

    public void setInizioPrestito(LocalDate inizioPrestito) {
        this.inizioPrestito = inizioPrestito;
    }

    public LocalDate getConsegnaPrevista() {
        return consegnaPrevista;
    }

    public void setConsegnaPrevista(LocalDate consegnaPrevista) {
        this.consegnaPrevista = consegnaPrevista;
    }

    public LocalDate getConsegnaEffettiva() {
        return consegnaEffettiva;
    }

    public void setConsegnaEffettiva(LocalDate consegnaEffettiva) {
        this.consegnaEffettiva = consegnaEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Readable> getPrestati() {
        return prestati;
    }

    public void setPrestati(List<Readable> prestati) {
        this.prestati = prestati;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "inizioPrestito=" + inizioPrestito +
                ", consegnaPrevista=" + consegnaPrevista +
                ", consegnaEffettiva=" + consegnaEffettiva +
                ", utente=" + utente +
                ", prestati=" + prestati +
                '}';
    }
}
