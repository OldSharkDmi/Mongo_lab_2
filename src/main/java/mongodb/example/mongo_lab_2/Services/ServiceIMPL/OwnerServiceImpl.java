package mongodb.example.mongo_lab_2.Services.ServiceIMPL;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Repositories.DogRepository;
import mongodb.example.mongo_lab_2.Repositories.OwnerRepository;
import mongodb.example.mongo_lab_2.Services.DogService;
import mongodb.example.mongo_lab_2.Services.OwnerService;
import mongodb.example.mongo_lab_2.exceptions.ClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    @Autowired
    DogService dogService;
    private final DogRepository dogRepository;
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, DogRepository dogRepository) {
        this.ownerRepository = ownerRepository;
        this.dogRepository = dogRepository;
    }
    @Override
    public void deleteOwnerWithDogs(String ownerId) {
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        if (owner != null) {
            List<String> dogIds = owner.getDogIds();
            for (String dogId : dogIds) {
                dogService.deleteDog(dogId);
            }
            ownerRepository.deleteById(ownerId);
        }
    }
    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getOwnerById(String ownerId) {
        return ownerRepository.findById(ownerId).orElse(null);
    }

    @Override
    public Owner updateOwner(String ownerId, Owner updatedOwner) {
        Owner existingOwner = ownerRepository.findById(ownerId).orElse(null);
        if (existingOwner != null) {
            existingOwner.setName(updatedOwner.getName());
            // Другие поля обновления
            return ownerRepository.save(existingOwner);
        }
        return null;
    }

    @Override
    public void deleteOwner(String ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public Owner findOwnerById(String ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(() -> new
                ClientErrorException.NotFoundException("Владелец с id=[%s] не найден", ownerId));
    }

    @Override
    public void deleteAllOwners() {
        ownerRepository.deleteAll();
    }
    /*
    @Override
    public void deleteOwnerAndCascade(String ownerId) {
        Owner ownerToDelete = ownerRepository.findById(ownerId).orElse(null);

        if (ownerToDelete != null) {
            ownerRepository.delete(ownerToDelete);

            for (Dog dog : ownerToDelete.getDogs()) {
                dogRepository.delete(dog);
            }
        }
    }
    @Override
    public void addDogToOwner(String ownerId, Dog dog) {
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        if (owner != null) {
            owner.getDogs().add(dog);
            ownerRepository.save(owner);
        }
    }

     */

    /*

    {
    "name": "Rex",
    "breed": "Golden Retriever",
    "color": "Yellow",
    "age": 3
}

     */
/*
    @Override
    public void removeDogFromOwner(String ownerId, String dogId) {
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        if (owner != null) {
            owner.getDogs().removeIf(d -> d.getId().equals(dogId));
            ownerRepository.save(owner);
        }
    }


 */


    public void addAllDogIdsToOwner(String ownerId) {

        List<Dog> allDogs = dogRepository.findAll();

        List<String> dogIds = allDogs.stream()
                .map(Dog::getId)
                .collect(Collectors.toList());

        Owner owner = ownerRepository.findById(ownerId).orElse(null);


        if (owner != null) {
            owner.setDogIds(dogIds);
            ownerRepository.save(owner);
        }
    }
}
