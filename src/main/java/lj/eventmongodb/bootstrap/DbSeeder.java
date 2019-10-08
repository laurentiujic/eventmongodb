package lj.eventmongodb.bootstrap;

import lj.eventmongodb.model.Address;
import lj.eventmongodb.model.Photo;
import lj.eventmongodb.repositories.HotelRepository;
import lj.eventmongodb.model.Hotel;
import lj.eventmongodb.model.Review;
import lj.eventmongodb.repositories.PhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;
    private PhotoRepository photoRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                ),
                Arrays.asList(
                        new Photo("fire"),
                        new Photo("earth")
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 8, false),
                        new Review("Mary", 7, true)
                ),
                Arrays.asList(
                        new Photo("fire"),
                        new Photo("earth")
                )
        );
        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                Arrays.asList(
                        new Review("Teddy", 8, false),
                        new Review("Laur", 9, true)
                ),
                Arrays.asList(
                        new Photo("fire"),
                        new Photo("earth")
                )
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot,ibis,sofitel);
        this.hotelRepository.saveAll(hotels);


    }
}
