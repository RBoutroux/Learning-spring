/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Person;
import java.util.Date;

/**
 *
 * @author remib
 */
public interface PersonRepositoryCustom {
    
    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param birthday
     * @return 
     */
    public Person update(int id, String firstName, String lastName, Date birthday);
}
