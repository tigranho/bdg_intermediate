package airport_management_system_JPA.dao;

import airport_management_system_JPA.model.Trip;

import java.util.List;
import java.util.Set;

public interface TripDAO {
    Trip getById(long id);
    Set<Trip> getAll();
    List<Trip> get(int page, int perPage, String sort);
    Trip save(Trip passenger);
    Trip update(long tripId, Trip trip);
    void delete(long tripId);
    List<Trip> getTripsFrom(String city);
    List<Trip> getTripsTo(String city);

}
