package mongodb.example.mongo_lab_2.Models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;


public abstract class BaseEntity {
    @Id
    protected String id;
    @Field(name="name")
    @Indexed(unique = true, sparse = true, direction = IndexDirection.ASCENDING, background = false)
    protected String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}