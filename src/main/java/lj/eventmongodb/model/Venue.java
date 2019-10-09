package lj.eventmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Document(collection = "Venues")
public class Venue {
    @Id
    private String id;
    private String name;
    private String description;
    private HashSet<OpeningHours> openingHours;
    private Address address;
    private List<Event> events;
    private List<Photo> photos;

    protected Venue() {
        this.openingHours = new HashSet<>();
        this.events = new ArrayList<>();
        this.photos = new ArrayList<>();

    }

    public Venue(String name) {
        super();
        this.name = name;
    }

    public Venue(String name, String description, HashSet<OpeningHours> openingHours,
                 Address address, List<Event> events, List<Photo> photos) {
        this.name = name;
        this.description = description;
        this.openingHours = openingHours;
        this.address = address;
        this.events = events;
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashSet<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(HashSet<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
