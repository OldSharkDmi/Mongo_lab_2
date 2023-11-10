package mongodb.example.mongo_lab_2.Repositories;

import mongodb.example.mongo_lab_2.Models.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DogRepository extends MongoRepository<Dog, String> {
    @Query("{ 'name' : ?0 }")
    Optional<Dog> findByName(String name);

    /*
    Optional<Dog> getByTitle(String title);
    List<Dog> findByName(String title);
    List<Dog> findByTitleNot(String title);
    List<Dog> findByTitleContaining(String string);
    List<Dog> findByTitleNotContaining(String title);
    List<Dog> findByTitleMatches(String string);
    List<Dog> findByPublishedAfter(LocalDate date);
    List<Dog> findByPublishedGreaterThanEqual(LocalDate date);
    @Query("{ 'published': { $gte: ?0, $lte: ?1 } }")
    List<Dog> findByPublishedBetween(LocalDate starting, LocalDate ending);
    Page<Dog> findByPublishedAfter(LocalDate date, Pageable pageable);
    List<Dog> findByTitleNullAndPublishedAfter(LocalDate date);
    Slice<Dog> findByTitleNullAndPublishedAfter(LocalDate date, Pageable
            pageable);
    Page<Dog> findPageByTitleNullAndPublishedAfter(LocalDate date, Pageable
            pageable);
    List<Dog> findByTitleStartingWith(String string, Sort sort);
    Slice<Dog> findByTitleStartingWith(String string, Pageable pageable);
    Page<Dog> findPageByTitleStartingWith(String string, Pageable pageable);

     */
}
