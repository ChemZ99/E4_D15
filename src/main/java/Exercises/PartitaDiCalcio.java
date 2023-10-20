package Exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class PartitaDiCalcio extends Evento {
    @Column
    private String teamInCasa;
    @Column
    private String teamOspite;
    @Column
    private String vincitore;
    @Column
    private int golCasa;
    @Column
    private int golOspite;

    public PartitaDiCalcio (){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Partecipazione> partecipazioni, Location location, String teamInCasa, String teamOspite, String vincitore, int golCasa, int golOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, partecipazioni, location);
        this.teamInCasa = teamInCasa;
        this.teamOspite = teamOspite;
        this.vincitore = vincitore;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
    }

    public String getTeamInCasa() {
        return teamInCasa;
    }

    public void setTeamInCasa(String teamInCasa) {
        this.teamInCasa = teamInCasa;
    }

    public String getTeamOspite() {
        return teamOspite;
    }

    public void setTeamOspite(String teamOspite) {
        this.teamOspite = teamOspite;
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "teamInCasa='" + teamInCasa + '\'' +
                ", teamOspite='" + teamOspite + '\'' +
                ", vincitore='" + vincitore + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                "} " + super.toString();
    }
}
