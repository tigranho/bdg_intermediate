package airport_management_system_JPA.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Company {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private LocalDate found_date;


    public Company(){}

    public Company(String name, LocalDate found_date){
        this.name = name;
        this.found_date = found_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFound_date() {
        return found_date;
    }

    public void setFound_date(LocalDate found_date) {
        this.found_date = found_date;
    }

    @Override
    public String toString() {
        return name + " " + found_date;
    }
}
