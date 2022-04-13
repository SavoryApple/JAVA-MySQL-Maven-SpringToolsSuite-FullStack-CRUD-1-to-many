package com.seannavery.dojosandninjas.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.seannavery.dojosandninjas.models.Dojo;
import com.seannavery.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
    // adding the book repository as a dependency
    private final DojoRepository dojoRepository;
    
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    // returns all the books
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a book
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    //deletes a book
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
    
    // updates a book
     public Dojo updateDojo(Dojo dojo) {
    	Long dojoId = dojo.getId();
    	String dojoName = dojo.getName();
    	String dojoLocation = dojo.getLocation();
    	Dojo dojoToUpdate = this.findDojo(dojoId);   //set method below for this to work	
    	dojoToUpdate.setName(dojoName);
    	dojoToUpdate.setLocation(dojoLocation);
    	dojoRepository.save(dojoToUpdate);
        return dojoToUpdate;
    }
    // retrieves a book
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
