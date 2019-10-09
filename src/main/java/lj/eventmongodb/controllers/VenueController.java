package lj.eventmongodb.controllers;

import lj.eventmongodb.model.Address;
import lj.eventmongodb.model.Venue;
import lj.eventmongodb.model.Photo;
import lj.eventmongodb.repositories.VenueRepository;
import lj.eventmongodb.services.VenueService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller

@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    private VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        List<Venue> venues = this.venueRepository.findAll();
        model.addAttribute("venues", venues);
        return "index";}

    @PutMapping
    public void insert(@RequestBody Venue venue){
        this.venueRepository.insert(venue);
    }

    @PostMapping
    public void update(@RequestBody Venue venue){
        this.venueRepository.save(venue);
    }

    @GetMapping("/createVenue")
    public String createVenue(Model model) {
        model.addAttribute("message", "hello");
        return "createVenue";
    }

    @PostMapping("/add")
    public String addVenue(@RequestParam("name") String name,
                           @RequestParam("venueDescription") String venueDescription,
                           @RequestParam("address") String address,
                           @RequestParam("city") String city, @RequestParam("country") String country,
                           @RequestParam("imageTitle") String imageTitle,
                           @RequestParam("image") MultipartFile image, Model model) throws IOException {
        Address venueAddress = new Address(address, city, country);
        Photo photo = new Photo(imageTitle);

        // saving booth image as binary and string dont know if I will ever need the binary
        photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        photo.setImageString(venueService
                .getPhotoEncodedString(new Binary(BsonBinarySubType.BINARY, image.getBytes())));

        // list of photos because I am planing to have more then one image per venue - in a future version
        List<Photo> photos = Arrays.asList(photo);
        String id = venueService.addVenue(name, venueDescription, venueAddress, photos);
        return "redirect:/venues/" +id;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id, Model model){
        Venue venue = this.venueRepository.findById(id).get();
        model.addAttribute("name", venue.getName());
        model.addAttribute("venueDescription", venue.getDescription());
        model.addAttribute("address", venue.getAddress().getAddress());
        model.addAttribute("city", venue.getAddress().getCity());
        model.addAttribute("country", venue.getAddress().getCountry());
        model.addAttribute("images", venueService.getPhotosEncodedString(id));
        return "venue";
    }
}