package mongodb.example.mongo_lab_2;



import mongodb.example.mongo_lab_2.Models.Dog;
import mongodb.example.mongo_lab_2.Models.Owner;
import mongodb.example.mongo_lab_2.Services.DogService;
import mongodb.example.mongo_lab_2.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class MongoLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(MongoLab2Application.class, args);
    }

    @Component
    public class Init implements org.springframework.boot.CommandLineRunner {

        @Autowired
        DogService dogService;
        @Autowired
        OwnerService ownerService;

        @Override
        public void run(String... args) throws Exception {
            /*
            Dog igu = new Dog("Igu", "Gungan","Black", 5);
            Dog iguS = dogService.createDog(igu);
            Dog dog1 = new Dog("Ut", "Labrador","Black", 5);
            Dog dogS1 = dogService.createDog(igu);
             */
            List<String> dogs = new ArrayList<>();
            List<Dog> first10Dogs = dogService.getFirst10Dogs();

            for (Dog dog : first10Dogs) {
                dogs.add(dog.getId());
            }




            Owner owner = new Owner("Alex", "Atavin");
            owner.setDogIds(dogs);
            ownerService.createOwner(owner);

            /*
            Dog dog1 = new Dog("Slava", "Terekhov", "Yellow", 3);
            Dog dog2 = new Dog("Pavel", "Sidorov", "Black", 2);
            ownerService.addDogToOwner(owner.getId(), dog1);
            ownerService.addDogToOwner(owner.getId(), dog2);

             */





        }
    }

}