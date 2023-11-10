package mongodb.example.mongo_lab_2.Services;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Repositories.DogRepository;
import mongodb.example.mongo_lab_2.Repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {

    Owner createOwner(Owner owner);

    List<Owner> getAllOwners();

    Owner getOwnerById(String ownerId);

    Owner updateOwner(String ownerId, Owner updatedOwner);

    void deleteOwner(String ownerId);

    void deleteAllOwners();
//void deleteOwnerAndCascade(String ownerId);
  //  void addDogToOwner(String ownerId, Dog dog);
    void deleteOwnerWithDogs(String ownerId);

   // void removeDogFromOwner(String ownerId, String dogId);

    Owner findOwnerById(String ownerId);
}