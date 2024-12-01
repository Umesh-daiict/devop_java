package sun.dev.ijobs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IjobsRepogistry  extends MongoRepository<Ijob, ObjectId> {
    Optional<List<Ijob>> findAllIjobByType(String type);
}
