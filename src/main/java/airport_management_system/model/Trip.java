package airport_management_system.model;

import airport_management_system.dao.impl.CompanyDAOImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Trip {
    private long id;
    private Company company;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private String townTo;
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
