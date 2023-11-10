package mongodb.example.mongo_lab_2.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Owner")
public class Owner extends BaseEntity {


    private String surname;


    @Field
    private List<String> dogIds;
    //List<Dog> allDogs = dogRepository.findAll();
    /*
    List<String> dogIds = allDogs.stream()
            .map(Dog::getId)
            .collect(Collectors.toList());
    Owner owner = ownerRepository.findById(ownerId).orElse(null);

     */

    public Owner() {
        this.dogIds = new ArrayList<>();
    }

    public List<String> getDogIds() {
        return dogIds;
    }

    public void setDogIds(List<String> dogIds) {
        this.dogIds = dogIds;
    }

    public void addDogId(String dogId) {
        this.dogIds.add(dogId);
    }

    public void removeDogId(String dogId) {
        this.dogIds.remove(dogId);
    }

    public Owner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }





    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}



