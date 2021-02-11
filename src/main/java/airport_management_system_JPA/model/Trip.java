package airport_management_system_JPA.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Company company;
    @Column(name = "time_in")
    private LocalDateTime timeIn;
    @Column(name = "time_out")
    private LocalDateTime timeOut;
    @Column(name = "town_to")
    private String townTo;
    @Column(name = "town_from")
    private String townFrom;

    public Trip(){}

    public Trip(LocalDateTime timeIn, LocalDateTime timeOut, String townTo, String townFrom, Company company){
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.townTo = townTo;
        this.townFrom = townFrom;
        this.company = company;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    @Override
    public String toString() {
        return timeIn + " " + timeOut + " " + townTo + " " + townFrom + " " + company;
    }
}
