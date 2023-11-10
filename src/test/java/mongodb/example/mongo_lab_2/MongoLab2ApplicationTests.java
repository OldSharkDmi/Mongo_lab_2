package mongodb.example.mongo_lab_2;

import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Services.OwnerService;
import mongodb.example.mongo_lab_2.exceptions.ClientErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MongoLab2ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private OwnerService ownerService;

    @Test
    public void testCreateOwner() {
        Owner owner = new Owner("Pavel", "Sidorov");
        Owner savedOwner = ownerService.createOwner(owner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    public void testReadOwner() {
        Owner owner = new Owner("Vova", "Smith");
        Owner savedOwner = ownerService.createOwner(owner);

        Owner retrievedOwner = ownerService.findOwnerById(savedOwner.getId());
        assertNotNull(retrievedOwner);
        Assertions.assertEquals("Vova", retrievedOwner.getName());
    }

    @Test
    public void testUpdateOwner() {
        Owner owner = new Owner("Artem", "Ashurkin");
        Owner savedOwner = ownerService.createOwner(owner);

        String ownerId = savedOwner.getId();
        savedOwner.setName("Femboy");
        Owner updatedOwner = ownerService.updateOwner(ownerId, savedOwner);

        Assertions.assertEquals("Femboy", updatedOwner.getName());
    }


    @Test
    public void testDeleteOwner() {
        Owner owner = new Owner("Slava", "Genius");
        Owner savedOwner = ownerService.createOwner(owner);

        ownerService.deleteOwner(savedOwner.getId());

        Assertions.assertThrows(ClientErrorException.NotFoundException.class, () -> {
            ownerService.findOwnerById(savedOwner.getId());
        });
    }

}
