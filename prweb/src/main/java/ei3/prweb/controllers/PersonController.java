/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;


import ei3.prweb.items.Person;
import ei3.prweb.repositories.PersonRepository;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
    
    private Date getDateFromString(String aDate, String format){
        Date returnedValue = null;
        
        try {
            // try to convert
            SimpleDateFormat aFormater = new SimpleDateFormat(format);
            returnedValue = aFormater.parse(aDate);
        }
        catch (ParseException ex) {
        }
        
        if (returnedValue != null) {
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(returnedValue);
        }
        return returnedValue;
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
            returned.addObject("user", person);
        }
        else {
            returned = new ModelAndView("users");
            Collection<Person> myList = personRepository.findAll();
            returned.addObject("usersList", myList);
        }
        return returned;
    }
    
    @RequestMapping(value = "saveUser.do", method = RequestMethod.POST)
    public ModelAndView handlePostSaveUser(HttpServletRequest request){
        ModelAndView returned;
        
        // Create or update user
        try {
            request.setCharacterEncoding("UTF-8");
        }
        catch (UnsupportedEncodingException ex){
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String idStr = request.getParameter("id");
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String birthdateStr = request.getParameter("Birthdate");
        Date birthday = getDateFromString(birthdateStr, "yyyy-MM-dd");
        
        int id = getIntFromString(idStr);
        personRepository.update(id, firstName, lastName, birthday);
        
        // return view
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);
        
        return returned;
    }
    
    @RequestMapping(value= "deleteUser.do", method = RequestMethod.POST)
    public ModelAndView handlePostDeleteUser(HttpServletRequest request){
        ModelAndView returned;
        
        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        
        personRepository.remove(id);
        
        // return view
        returned = new ModelAndView("users");
        Collection<Person> myList = personRepository.findAll();
        returned.addObject("usersList", myList);
        
        return returned;
    }
}
