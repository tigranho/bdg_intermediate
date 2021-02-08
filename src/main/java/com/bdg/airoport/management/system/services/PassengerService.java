package com.bdg.airoport.management.system.services;

import java.util.List;
import java.util.Set;

public interface PassengerService {
    com.bdg.airoport.management.system.model.Passenger getById(long id);

    Set<com.bdg.airoport.management.system.model.Passenger> getAll();

    Set<com.bdg.airoport.management.system.model.Passenger> get(int page, int perPage, String sort);

    com.bdg.airoport.management.system.model.Passenger save(com.bdg.airoport.management.system.model.Passenger passenger);

    com.bdg.airoport.management.system.model.Passenger update(com.bdg.airoport.management.system.model.Passenger passenger);

    void delete(long passengerId);

    List<com.bdg.airoport.management.system.model.Passenger> getPassengersOfTrip(long tripNumber);
}
