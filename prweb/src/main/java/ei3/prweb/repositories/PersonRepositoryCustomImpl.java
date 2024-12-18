/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Person;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author remib
 */
@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {
    
    @Autowired
    @Lazy
    PersonRepository personRepository;
    
    @Override
    public Person update(int id, String firstName, String lastName, Date birthday) {
        Person item = null;
        
        if (id > 0){
            item = personRepository.getReferenceById(id);
        }
        if((item != null) && (firstName != null) && (lastName != null) && (birthday != null)){
            item.setPersonFirstname(firstName);
            item.setPersonLastname(lastName);
            item.setPersonBirthdate(birthday);
            personRepository.saveAndFlush(item);
        }
        return item;
    }

    @Override
    public void remove(int id) {
        Person item = null;
        if (id > 0){
            item = personRepository.getReferenceById(id);
        }
        if(item != null){
            personRepository.delete(item);
        }
    }
    
}
