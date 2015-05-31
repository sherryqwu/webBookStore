/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import java.util.ArrayList;

/**
 *
 * @author Sherry
 */
public class NewBooks {
    private ArrayList<Book> newBooks;
    
    public void newNewBook(Book book){
        newBooks.add(book);
     }

    public ArrayList<Book> getNewBooks() {
        return newBooks;
    }

    public void setNewBooks(ArrayList<Book> newBooks) {
        this.newBooks = newBooks;
    }
    
    
}
