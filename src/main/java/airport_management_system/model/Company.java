package airport_management_system.model;

import java.time.LocalDate;
import java.util.Set;

public class Company {
    private long id;
    private String name;
    private LocalDate found_date;
    private Set<Trip> tripSet;


    public Company(){}

    public Company(String name, LocalDate found_date){
        this.name = name;
        this.found_date = found_date;
    }

    public Company(String name, LocalDate localDate, Set<Trip> tripSet) {
        this(name, localDate);
        this.tripSet = tripSet;
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
