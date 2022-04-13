package com.seannavery.dojosandninjas.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.seannavery.dojosandninjas.models.Ninja;
import com.seannavery.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    // adding the book repository as a dependency
    private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    // returns all the books
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a book
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    //deletes a book
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
    
    // updates a book
     public Ninja updateNinja(Ninja ninja) {
    	Long ninjaId = ninja.getId();
    	String ninjaFirstName = ninja.getFirstName();
    	String ninjaLastName = ninja.getLastName();
    	Integer ninjaAge = ninja.getAge();
    	Ninja ninjaToUpdate = this.findNinja(ninjaId);   //set method below for this to work	
    	ninjaToUpdate.setFirstName(ninjaFirstName);
    	ninjaToUpdate.setLastName(ninjaLastName);
    	ninjaToUpdate.setAge(ninjaAge);
    	ninjaRepository.save(ninjaToUpdate);
        return ninjaToUpdate;
    }
    // retrieves a book
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
}