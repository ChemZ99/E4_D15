package Exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "rivista")
public class Magazine extends Readable {
    @Enumerated
    @Column
    private Period period;

    public Magazine(){}
    public Magazine(int ISBN, String title, LocalDate published, int pages, Period period) {
        super(ISBN, title, published, pages);
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "period=" + period +
                "} " + super.toString();
    }
}
