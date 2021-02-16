package com.bdg.homework5.entity;

import com.bdg.homework5.entity.Company;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Basic
    //@Temporal(TemporalType.TIMESTAMP)
    Timestamp time_in;

    @Basic
   // @Temporal(TemporalType.TIMESTAMP)
    Timestamp time_out;

    @Column
    String town_from;
    @Column
    String town_to;

    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    public Trip() {
    }

    public Trip(Timestamp time_in, Timestamp time_out, String town_from, String town_to) {
        this.time_in = time_in;
        this.time_out = time_out;
        this.town_from = town_from;
        this.town_to = town_to;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Timestamp getTime_in() {
        return time_in;
    }

    public void setTime_in(Timestamp time_in) {
        this.time_in = time_in;
    }

    public Timestamp getTime_out() {
        return time_out;
    }

    public void setTime_out(Timestamp time_out) {
        this.time_out = time_out;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public String getTown_to() {
        return town_to;
    }

    public void setTown_to(String town_to) {
        this.town_to = town_to;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Id=" + Id +
                ", time_in=" + time_in +
                ", time_out=" + time_out +
                ", town_from='" + town_from + '\'' +
                ", town_to='" + town_to + '\'' +
                ", company=" + company.getName() + "company_id = " + company.getId()+
                '}';
    }
}
