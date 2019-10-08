package lj.eventmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pricePerNight;
    private Address address;
    private List<Review> reviews;
    private List<Photo> photos;

    protected Hotel() {
        this.reviews = new ArrayList<>();
        this.photos = new ArrayList<>();

    }

    public Hotel(String name, int pricePerNight) {
        super();
        this.name = name;
        this.pricePerNight = pricePerNight;
    }

    public Hotel(String name, int pricePerNight, Address address, List<Review> reviews, List<Photo> photos) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.reviews = reviews;
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public Address getAddress() {
        return address;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
