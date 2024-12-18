/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.repositories;

import ei3.prweb.items.Book;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 *
 * @author remib
 */
@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom {

    @Autowired
    @Lazy
    private BookRepository bookRepository;

    @Override
    public Book create(String title, String authors) {
        if ((title != null) && (authors != null)) {
            Book item = new Book();
            item.setBookTitle(title);
            item.setBookAuthors(authors);
            bookRepository.saveAndFlush(item);

            Optional<Book> result = bookRepository.findById(item.getBookId());
            if (result.isPresent()) {
                return result.get();
            }
        }
        return null;
    }

    @Override
    public void remove(int id) {
        Book item = null;
        if (id > 0) {
            item = bookRepository.getReferenceById(id);
        }
        if (item != null) {
            bookRepository.delete(item);
        }
    }

    @Override
    public Book update(int id, String title, String authors) {
        Book item = null;
        if (id > 0) {
            item = bookRepository.getReferenceById(id);
        }
        if ((item != null) && (title != null) && (authors != null)) {
            item.setBookTitle(title);
            item.setBookAuthors(authors);
            bookRepository.saveAndFlush(item);
        }
        return item;
    }
    
}
