package mongodb.example.mongo_lab_2.Repositories;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<Owner, String> {}
