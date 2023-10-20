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
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "libro_id")
    private Readable readable;

    public Prestito () {
    }

    public Prestito(LocalDate inizioPrestito, LocalDate consegnaEffettiva, Utente utente, Readable prestato) {
        this.inizioPrestito = inizioPrestito;
        this.consegnaEffettiva = consegnaEffettiva;
        this.utente = utente;
        this.readable = prestato;
        consegnaPrevista = inizioPrestito.plusDays(30);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Readable getPrestato() {
        return readable;
    }

    public void setPrestato(Readable prestato) {
        this.readable = prestato;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "inizioPrestito=" + inizioPrestito +
                ", consegnaPrevista=" + consegnaPrevista +
                ", consegnaEffettiva=" + consegnaEffettiva +
                ", utente=" + utente +
                ", prestato=" + readable +
                '}';
    }
}
