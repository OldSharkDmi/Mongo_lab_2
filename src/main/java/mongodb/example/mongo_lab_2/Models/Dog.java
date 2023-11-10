package mongodb.example.mongo_lab_2.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "Dog")
@CompoundIndex(def="{'name':1, 'breed':-1}", unique = true, background
        = false, sparse = false)
public class Dog extends BaseEntity {
        private String breed;
        private String color;
        private int age;
    @DBRef
    private Owner owner;
        public Dog(String name, String breed, String color, int age) {
            this.name = name;
            this.breed = breed;
            this.color = color;
            this.age=age;
        }



    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    @Override
        public String toString() {
            return "Dog{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", breed='" + breed + '\'' +
                    ", age=" + age +'\'' +
                    ", color=" + color +
                    '}';
        }
    }


