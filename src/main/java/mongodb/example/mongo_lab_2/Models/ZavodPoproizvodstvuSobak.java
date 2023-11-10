package mongodb.example.mongo_lab_2.Models;

import com.github.javafaker.Faker;

import java.util.function.UnaryOperator;

public class ZavodPoproizvodstvuSobak {
    private final Faker faker = new Faker();

    public String name() {
        return faker.name().name();
    }

    public String breed() {
        return faker.name().name();
    }

    public String color() {
        return faker.name().lastName();
    }




}
