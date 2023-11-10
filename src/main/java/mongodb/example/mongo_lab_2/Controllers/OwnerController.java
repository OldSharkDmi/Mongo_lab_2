package mongodb.example.mongo_lab_2.Controllers;

import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    /*
    @DeleteMapping("/{ownerId}")
    public void deleteOwnerAndCascade(@PathVariable String ownerId) {
        ownerService.deleteOwnerAndCascade(ownerId);
    }

     */
/*
    @PostMapping("/{ownerId}/dogs")
    public void addDogToOwner(@PathVariable String ownerId, @RequestBody Dog dog) {
        ownerService.addDogToOwner(ownerId, dog);
    }

 */

    @DeleteMapping("/{ownerId}")
    public ResponseEntity<String> deleteOwner(@PathVariable String ownerId) {
        ownerService.deleteOwner(ownerId);
        return ResponseEntity.ok("Owner with ID " + ownerId + " has been deleted.");
    }
    @DeleteMapping("/deleteOwnerWithDogs/{ownerId}")
    public ResponseEntity<String> deleteOwnerWithDogs(@PathVariable String ownerId) {
        Owner owner = ownerService.findOwnerById(ownerId);
        if (owner == null) {
            return ResponseEntity.notFound().build();
        }

        ownerService.deleteOwnerWithDogs(ownerId);
        return ResponseEntity.ok("Owner with ID " + ownerId + " and associated dogs have been deleted.");
    }



}


