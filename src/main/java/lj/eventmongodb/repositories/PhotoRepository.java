package lj.eventmongodb.repositories;

import lj.eventmongodb.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {
}
