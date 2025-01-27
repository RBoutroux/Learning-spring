/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author remib
 */
@Repository
public interface BorrowRepository  extends JpaRepository<Borrow, Integer>, BorrowRepositoryCustom {
    
}
