/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Borrow;
import java.util.Date;

/**
 *
 * @author remib
 */
public interface BorrowRepositoryCustom {
    public Borrow returnBook(Borrow item, Date date);
    
    public Borrow returnBook(Borrow item);
    
    public Borrow returnBook(int borrowId);
}
