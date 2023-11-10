package mongodb.example.mongo_lab_2.Services;

import mongodb.example.mongo_lab_2.Models.Dog;

import java.util.List;

public interface DogService {

    Dog createDog(Dog dog);

    void deleteDog(String dogId);
   List<Dog> getFirst10Dogs();

    Dog get(String id);
    public Dog findDogByName(String name);

    void deleteAllDogs();
    Dog updateDog(String id, Dog dog);
    List<Dog> saveAllDogs(List<Dog> dogs);


    List<Dog> getAllDog();

    /*
    Dog createDog(Dog dog);
    Dog getDog(UUID id);
    void deleteDog(UUID id);
    void deleteAllDogs();
    void saveAllDogs(List<Dog> dogs);
    Page<Dog> getDogs(Pageable pageable);
    List<Dog> getAllDogs();
    Page<Dog> findPublishedAfter(LocalDate exclusive, Pageable pageable);
    Page<Dog> findDogsMatchingAll(Dog probe, Pageable pageable);

     */
}
