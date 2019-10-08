package lj.eventmongodb.services;

import lj.eventmongodb.model.Address;
import lj.eventmongodb.model.Hotel;
import lj.eventmongodb.model.Photo;
import lj.eventmongodb.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).get();
    }

    public String addHotel(String name, int pricePerNight,
                           Address address, List<Photo> photos) throws IOException {
        Hotel hotel = new Hotel(name, pricePerNight);
        hotel.setAddress(address);
        hotel.setPhotos(photos);
        hotel = hotelRepository.insert(hotel);
        return hotel.getId();
    }


    public List<String> getPhotosEncodedString(String id) {
        Hotel hotel = getHotel(id);
        List<String> imageStringObject = new LinkedList<>();
        for (Photo image : hotel.getPhotos()){
            imageStringObject.add(Base64.getEncoder().encodeToString(image.getImage().getData()));
        }
        return imageStringObject;
    }
}
