/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;

import ei3.prweb.items.Book;
import ei3.prweb.items.Borrow;
import ei3.prweb.items.Person;
import ei3.prweb.repositories.BookRepository;
import ei3.prweb.repositories.BorrowRepository;
import ei3.prweb.repositories.PersonRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author remib
 */
@Controller
public class BorrowController {
    
    @Autowired
    private BorrowRepository borrowRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    /**
     * Get Date from string
     *
     * @param aDate
     * @param format
     * @return
     */
    private Date getDateFromString(String aDate, String format) {
        Date returnedValue = null;
        try {
            // try to convert
            SimpleDateFormat aFormater = new SimpleDateFormat(format);
            returnedValue = aFormater.parse(aDate);
        } catch (ParseException ex) {
        }

        if (returnedValue != null) {
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(returnedValue);
        }
        return returnedValue;
    }

    /**
     * Get int from String
     *
     * @param value
     * @return
     */
    private int getIntFromString(String value) {
        int intValue = -1;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.WARNING, null, ex);
        }
        return intValue;
    }
    
    
    @RequestMapping(value="returnBorrow.do", method = RequestMethod.POST)
    public ModelAndView handleReturn(HttpServletRequest request){
        ModelAndView returned = new ModelAndView("ajax");
        JSONObject returnedObject = new JSONObject();
        
        String borrowStr = request.getParameter("id");
        int borrowId = getIntFromString(borrowStr);
        
        Borrow borrow = borrowRepository.returnBook(borrowId);
        if(borrow != null){
            returnedObject.append("id", borrow.getBorrowId());
        }
        else {
            returned.setStatus(HttpStatus.BAD_REQUEST);
        }
        returned.addObject("theResponse", returnedObject.toString());
        
        return returned;
    }
    
    @RequestMapping(value="addBorrow.do", method = RequestMethod.POST)
    public ModelAndView handleAddBorrow(HttpServletRequest request){
        String userStr = request.getParameter("userID");
        int userId = getIntFromString(userStr);
        Person user = personRepository.getReferenceById(userId);
        
        String bookStr = request.getParameter("bookID");
        int bookId = getIntFromString(bookStr);
        Book book = bookRepository.getReferenceById(bookId);
        
        borrowRepository.create(user, book);
        //Refresh user data (bookCollection)
        user = personRepository.getReferenceById(userId);
        
        ModelAndView returned = new ModelAndView("user");
        returned.addObject("user", user);
        returned.addObject("booksList", bookRepository.findAll());
        
        return returned;
    }
    
    @RequestMapping(value="borrows.do", method = RequestMethod.POST)
    public ModelAndView handleBorrowsPost(HttpServletRequest request){
        
        ModelAndView returned = new ModelAndView("borrows");
        returned.addObject("borrows", borrowRepository.findAll());
        
        return returned;
    }
}
