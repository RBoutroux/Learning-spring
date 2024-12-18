/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;

import ei3.prweb.items.Book;
import ei3.prweb.repositories.BookRepository;
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
public class BookController {
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
    
     @RequestMapping(value = "editbook.do", method = RequestMethod.POST)
    public ModelAndView handleEditBookPost(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);

        if (id > 0) {
            // ID may exist
            Book Book = bookRepository.getReferenceById(id);
            returned = new ModelAndView("book");
            returned.addObject("book", Book);
        } else {
            returned = new ModelAndView("books");
            Collection<Book> myList = bookRepository.findAll();
            returned.addObject("booksList", myList);
        }
        return returned;
    }
    
    @RequestMapping(value = "savebook.do", method = RequestMethod.POST)
    public ModelAndView handlePostSaveBook(HttpServletRequest request) {
        ModelAndView returned;

        // Create or update book
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idStr = request.getParameter("id");
        String title = request.getParameter("Title");
        String authors = request.getParameter("Authors");
        int id = getIntFromString(idStr);
        if (id < 0) {
            bookRepository.create(title, authors);
        } else {
            bookRepository.update(id, title, authors);
        }

        // return view
        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }

    @RequestMapping(value = "deletebook.do", method = RequestMethod.POST)
    public ModelAndView handlePostDeletebook(HttpServletRequest request) {
        ModelAndView returned;

        String idStr = request.getParameter("id");
        int id = getIntFromString(idStr);
        bookRepository.remove(id);

        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }
    
    @RequestMapping(value = "createbook.do", method = RequestMethod.POST)
    public ModelAndView handlePostCreatebook() {
        ModelAndView returned;

        Book newBook = new Book();
        returned = new ModelAndView("book");
        returned.addObject("book", newBook);

        return returned;
    }
    
    @RequestMapping(value = "books.do")
    public ModelAndView handleLBooksPost(HttpServletRequest request) {
        ModelAndView returned;

        returned = new ModelAndView("books");
        Collection<Book> myList = bookRepository.findAll();
        returned.addObject("booksList", myList);

        return returned;
    }
}
