/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ei3.prweb.controllers;

import ei3.prweb.items.Book;

/**
 *
 * @author remib
 */
public class BookBorrows {
    private Book book;
    private int numberOfBorrows;

    public BookBorrows() {
    }

    public BookBorrows(Book book) {
        this.book = book;
        this.numberOfBorrows = 0;
    }

    public BookBorrows(Book book, int numberOfBorrows) {
        this.book = book;
        this.numberOfBorrows = numberOfBorrows;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumberOfBorrows() {
        return numberOfBorrows;
    }

    public void setNumberOfBorrows(int numberOfBorrows) {
        this.numberOfBorrows = numberOfBorrows;
    }
}
