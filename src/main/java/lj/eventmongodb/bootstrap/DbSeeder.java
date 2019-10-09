package lj.eventmongodb.bootstrap;

import lj.eventmongodb.repositories.VenueRepository;
import lj.eventmongodb.repositories.PhotoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class DbSeeder implements CommandLineRunner {
    private VenueRepository venueRepository;
    private PhotoRepository photoRepository;

    public DbSeeder(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public void run(String... args) throws Exception {


/*        Venue marriot = new Venue(
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

        Venue ibis = new Venue(
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
        Venue sofitel = new Venue(
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
        );*/


        //add our hotels to the database
        /*List<Venue> hotels = Arrays.asList(marriot,ibis,sofitel);
        this.hotelRepository.saveAll(hotels);*/


    }
}
