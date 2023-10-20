package Exercises;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private LocalDate nascita;
    @Column
    private long numTessera;
    @OneToMany(mappedBy = "utente")
    @Column
    private List<Prestito> prestiti = new ArrayList<>();

    public Utente () {}

    public Utente(String nome, String cognome, LocalDate nascita, long numTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.numTessera = numTessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    public long getNumTessera() {
        return numTessera;
    }

    public void setNumTessera(long numTessera) {
        this.numTessera = numTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nascita=" + nascita +
                ", numTessera=" + numTessera +
                '}';
    }
}
