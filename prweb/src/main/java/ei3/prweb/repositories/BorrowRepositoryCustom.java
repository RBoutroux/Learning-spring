/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Book;
import ei3.prweb.items.Borrow;
import ei3.prweb.items.Person;
import java.util.Date;

/**
 *
 * @author remib
 */
public interface BorrowRepositoryCustom {
    public Borrow returnBook(Borrow item, Date date);
    
    public Borrow returnBook(Borrow item);
    
    public Borrow returnBook(int borrowId);
    
    public Borrow create(Person person, Book book, Date borrowDate);
    
    public Borrow create(Person person, Book book);
}
