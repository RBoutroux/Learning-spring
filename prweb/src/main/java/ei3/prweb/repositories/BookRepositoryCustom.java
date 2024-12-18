/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Book;

/**
 *
 * @author remib
 */
public interface BookRepositoryCustom{
     /**
     * Create book
     * @param title
     * @param authors
     * @return 
     */
    public Book create(String title, String authors);

    /**
     * Remove book
     * @param id 
     */
    public void remove(int id);

    /**
     * Update book
     * @param id
     * @param title
     * @param authors
     * @return 
     */
    public Book update(int id, String title, String authors);
}
