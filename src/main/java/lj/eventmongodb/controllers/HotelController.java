package lj.eventmongodb.controllers;


import lj.eventmongodb.model.Address;
import lj.eventmongodb.model.Hotel;
import lj.eventmongodb.model.Photo;
import lj.eventmongodb.repositories.HotelRepository;
import lj.eventmongodb.services.HotelService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller

@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();

        return hotels;
    }

    @PutMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
    }

    @PostMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }

    @GetMapping("/createHotel")
    public String createHotel(Model model) {
        model.addAttribute("message", "hello");
        return "createHotel";
    }

    @PostMapping("/add")
    public String addHotel(@RequestParam("name") String name, @RequestParam("pricePerNight") Integer pricePerNight,
                           @RequestParam("city") String city, @RequestParam("country") String country,
                           @RequestParam("imageTitle") String imageTitle,
                           @RequestParam("image") MultipartFile image, Model model) throws IOException {
        Address hotelAddress = new Address(city, country);
        Photo photo = new Photo(imageTitle);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        List<Photo> photos = Arrays.asList(photo);
        String id = hotelService.addHotel(name, pricePerNight, hotelAddress, photos);
        return "redirect:/hotels/" +id;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id, Model model){
        Hotel hotel = this.hotelRepository.findById(id).get();
        model.addAttribute("name", hotel.getName());
        model.addAttribute("pricePerNight", hotel.getPricePerNight());
        model.addAttribute("city", hotel.getAddress().getCity());
        model.addAttribute("country", hotel.getAddress().getCountry());
        model.addAttribute("images", hotelService.getPhotosEncodedString(id));
        return "hotel";
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels = this.hotelRepository.findByCity(city);
        return hotels;
    }
}