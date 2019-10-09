package lj.eventmongodb.services;

import lj.eventmongodb.model.Address;
import lj.eventmongodb.model.Venue;
import lj.eventmongodb.model.Photo;
import lj.eventmongodb.repositories.VenueRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue getVenue(String id) {
        return venueRepository.findById(id).get();
    }

    public String addVenue(String name, String description,
                           Address address, List<Photo> photos) throws IOException {
        Venue venue = new Venue(name);
        venue.setDescription(description);
        venue.setAddress(address);
        venue.setPhotos(photos);
        venue = venueRepository.insert(venue);
        return venue.getId();
    }

    public String getPhotoEncodedString (Binary image) {
        String imageStringObject = Base64.getEncoder().encodeToString(image.getData());
        return imageStringObject;
    }

    public List<String> getPhotosEncodedString(String id) {
        Venue venue = getVenue(id);
        List<String> imageStringObjects = new ArrayList<>();
        for (Photo image : venue.getPhotos()){
            imageStringObjects.add(Base64.getEncoder().encodeToString(image.getImage().getData()));
        }
        return imageStringObjects;
    }
}