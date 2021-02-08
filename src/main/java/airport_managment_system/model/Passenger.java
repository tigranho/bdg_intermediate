package airport_managment_system.model;

public class Passenger {
    private String passenger_name;
    private String passenger_phone;
    private Address address;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Passenger(String passenger_name, String passenger_phone, Address address) {

        this.passenger_name = passenger_name;
        this.passenger_phone = passenger_phone;
        this.address = address;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger{" + ", name='" + passenger_name + '\'' + ", phone='" + passenger_phone + '\'' + ", address=" + address + '}';
    }
}

