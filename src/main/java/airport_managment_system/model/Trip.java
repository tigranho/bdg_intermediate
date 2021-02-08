package airport_managment_system.model;

import java.time.LocalTime;

public class Trip {
    private long id;
    private Company company;
    private String town_too;
    private String town_from;
    private LocalTime time_in;
    private LocalTime time_out;


    public  Trip(){

    }

    public Trip(Company company, String town_too, String town_from, LocalTime time_in, LocalTime time_out) {
        this.company = company;
        this.town_too = town_too;
        this.town_from = town_from;
        this.time_in = time_in;
        this.time_out = time_out;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTown_too() {
        return town_too;
    }

    public void setTown_too(String town_too) {
        this.town_too = town_too;
    }

    public String getTown_from() {
        return town_from;
    }

    public void setTown_from(String town_from) {
        this.town_from = town_from;
    }

    public LocalTime getTime_in() {
        return time_in;
    }

    public void setTime_in(LocalTime time_in) {
        this.time_in = time_in;
    }

    public LocalTime getTime_out() {
        return time_out;
    }

    public void setTime_out(LocalTime time_out) {
        this.time_out = time_out;
    }

    @Override
    public String toString() {
        return "Trip{" + "id=" + id + ", company=" + company + ", time_in=" + time_in + ", time_out=" + time_out + ", town_too='" + town_too + '\'' + ", town_from='" + town_from + '\'' + '}';
    }
}
