/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;


import ei3.prweb.items.Person;
import ei3.prweb.repositories.PersonRepository;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author remib
 */
@Controller
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;
    
    private int getIntFromString(String value){
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        }
        catch (NumberFormatException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }
    
    @RequestMapping(value = "editUser.do", method = RequestMethod.POST)
    public ModelAndView handleEditUserPost(HttpServletRequest request){
        ModelAndView returned;
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        if (id > 0){
            // ID may exist
            Person person = personRepository.getReferenceById(id);
            returned = new ModelAndView("user");
            returned.addObject(idStr);
        }
        else {
            returned = new ModelAndView("users");
            Collection<Person> myList = personRepository.findAll();
            returned.addObject("usersList", myList);
        }
        return returned;
    }
}
