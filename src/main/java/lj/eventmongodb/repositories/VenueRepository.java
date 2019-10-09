package lj.eventmongodb.repositories;

import lj.eventmongodb.model.Venue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends MongoRepository<Venue, String> {

    /*List<Venue> findByPricePerNightLessThan(int maxPrice);

    @Query(value = "{'address.city':?0}")
    List<Venue> findByCity(String city);
*/


}
