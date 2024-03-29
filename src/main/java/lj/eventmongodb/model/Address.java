package lj.eventmongodb.model;

public class Address {
    private String address;
    private String city;
    private String country;

    protected Address(){}

    public Address(String address, String city, String country) {
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }
}
