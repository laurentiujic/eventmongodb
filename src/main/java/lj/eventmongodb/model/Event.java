package lj.eventmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "Events")
public class Event {
    @Id
    private String id;
    private String name;
    private String description;
    private Date date;
    private Integer time;
    private Address address;
    private List<Photo> photos;

    protected Event() {
        this.photos = new ArrayList<>();
    }

    public Event(String name, String description, Date date, Integer time, Address address) {
        super();
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.address = address;
    }

    public Event(String name, String description, Date date, Integer time, Address address, List<Photo> photos) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.address = address;
        this.photos = photos;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
