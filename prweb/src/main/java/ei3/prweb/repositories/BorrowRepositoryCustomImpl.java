/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Book;
import ei3.prweb.items.Borrow;
import ei3.prweb.items.Person;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author remib
 */
@Repository
public class BorrowRepositoryCustomImpl implements BorrowRepositoryCustom {
    
    @Autowired
    @Lazy
    private BorrowRepository borrowRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public Borrow returnBook(Borrow item, Date date) {
        if((item!=null)&&(date!=null)){
            item = borrowRepository.getReferenceById(item.getBorrowId());
            item.setBorrowReturn(date);
            borrowRepository.saveAndFlush(item);
            return item;
        }
        return null;
    }

    @Override
    public Borrow returnBook(Borrow item) {
        Calendar aCalendar = Calendar.getInstance();
        Date date = aCalendar.getTime();
        return returnBook(item, date);
    }

    @Override
    public Borrow returnBook(int borrowId) {
        if (borrowId > 0){
            Borrow item = borrowRepository.getReferenceById(borrowId);
            return returnBook(item);
        }
        return null;
    }

    @Override
    public Borrow create(Person person, Book book, Date borrowDate) {
        //Ensure we have full data
        if (person != null){
            person = personRepository.getReferenceById(person.getPersonId());
        }
        
        if (book != null){
            book = bookRepository.getReferenceById(book.getBookId());
        }
        
        //Build new borrow
        if((person !=null) && (book!=null)&&(borrowDate!=null)){
            Borrow item = new Borrow();
            item.setBookId(book);
            item.setPersonId(person);
            item.setBorrowDate(borrowDate);
            borrowRepository.saveAndFlush(item);
            
            Optional<Borrow> result = borrowRepository.findById(item.getBorrowId());
            if(result.isPresent()){
                item = result.get();
                
                //Set reverse fields
                person.getBorrowCollection().add(item);
                personRepository.saveAndFlush(person);
                book.getBorrowCollection().add(item);
                bookRepository.saveAndFlush(book);
                
                //return item
                return item;
            }
        }
        return null;
    }

    @Override
    public Borrow create(Person person, Book book) {
        Calendar aCalendar = Calendar.getInstance();
        Date date = aCalendar.getTime();
        return create(person, book, date);
    }
    
}
