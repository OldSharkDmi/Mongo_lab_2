package mongodb.example.mongo_lab_2.Controllers;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/byName/{name}")
    public Dog getDogByName(@PathVariable String name) {
        return dogService.findDogByName(name);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable String id)
    {
        Dog dog = dogService.get(id);
        if (dog != null) {
            return ResponseEntity.ok(dog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
        Dog createdDog = dogService.createDog(dog);
        return ResponseEntity.ok(createdDog);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable String id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }

}
