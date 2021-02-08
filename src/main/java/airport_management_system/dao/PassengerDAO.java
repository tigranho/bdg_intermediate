package airport_management_system.dao;

import airport_management_system.model.Passenger;
import airport_management_system.model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerDAO {
    Passenger getById(long id);
    Set<Passenger> getAll();
    Set<Passenger> get(int page, int perPage, String sort);
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger);
    void delete(long passengerId);
    List<Passenger> getPassengersOfTrip(long tripNumber);
    void registerTrip(Trip trip, Passenger passenger);
    void cancelTrip(long passengerId, long tripNumber);

}
