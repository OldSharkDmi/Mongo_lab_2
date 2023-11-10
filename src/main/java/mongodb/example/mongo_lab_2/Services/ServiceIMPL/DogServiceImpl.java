package mongodb.example.mongo_lab_2.Services.ServiceIMPL;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Repositories.DogRepository;
import mongodb.example.mongo_lab_2.Repositories.OwnerRepository;
import mongodb.example.mongo_lab_2.Services.DogService;
import mongodb.example.mongo_lab_2.exceptions.ClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DogServiceImpl implements DogService {
    @Override
    public List<Dog> getFirst10Dogs() {
        return dogRepository.findAll(PageRequest.of(0, 10)).getContent();
    }



    @Autowired
    DogRepository dogRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }


    @Override
    public void deleteDog(String dogId) {
        dogRepository.deleteById(dogId);
    }

    @Override
    public Dog get(String id) {
        return dogRepository.findById(id).orElseThrow(() -> new
                ClientErrorException.NotFoundException("Собака с id=[%s] не найдена", id));
    }

    @Override
    public Dog updateDog(String id, Dog updatedDog) {
        Dog existingDog = dogRepository.findById(id).orElse(null);
        if (existingDog != null) {
            if (updatedDog.getName() != null) {
                existingDog.setName(updatedDog.getName());
            }
            if (updatedDog.getBreed() != null) {
                existingDog.setBreed(updatedDog.getBreed());
            }
            if (updatedDog.getColor() != null) {
                existingDog.setColor(updatedDog.getColor());
            }
            if (updatedDog.getAge() > 0) {
                existingDog.setAge(updatedDog.getAge());
            }
            return dogRepository.save(existingDog);
        } else {
            return null; // Собака не найдена
        }
    }


    @Override
    public void deleteAllDogs() {
        dogRepository.deleteAll();
    }

    @Override
    public List<Dog> saveAllDogs(List<Dog> dogs) {
        dogRepository.saveAll(dogs);
        return dogs;
    }

    @Override
    public List<Dog> getAllDog() {
        return dogRepository.findAll();
    }

    @Override
    public Dog findDogByName(String name) {
        return dogRepository.findByName(name).orElse(null);
    }


    /*
    private final DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Dog getDog(UUID id) {
        return dogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDog(UUID id) {
        dogRepository.deleteById(id);
    }

    @Override
    public void deleteAllDogs() {
        dogRepository.deleteAll();
    }

    @Override
    public void saveAllDogs(List<Dog> dogs) {
        dogRepository.saveAll(dogs);
    }

     */


}
