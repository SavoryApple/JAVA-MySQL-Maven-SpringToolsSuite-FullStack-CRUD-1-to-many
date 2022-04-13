package com.seannavery.dojosandninjas.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.seannavery.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    // this method retrieves all the books from the database
    List<Dojo> findAll();
    // this method finds books with descriptions containing the search string
    List<Dojo> findByNameContaining(String search); //be CAREFUL with these bottom three
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);
}
