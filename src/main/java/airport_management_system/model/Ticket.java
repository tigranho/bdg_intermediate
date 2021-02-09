package airport_management_system.model;

public class Ticket {

    private Passenger passenger;
    private Trip trip;

    public Ticket(){

    }

    public Ticket(Passenger passenger, Trip trip){
        this.passenger = passenger;
        this.trip = trip;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }



}
