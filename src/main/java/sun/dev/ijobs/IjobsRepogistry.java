package sun.dev.ijobs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IjobsRepogistry  extends MongoRepository<Ijob, ObjectId> {

}
