/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Borrow;
import java.util.Calendar;
import java.util.Date;
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
    
}
