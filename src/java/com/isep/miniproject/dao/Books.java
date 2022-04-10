/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.miniproject.dao;

import com.isep.miniproject.models.BookModel;
import com.isep.miniproject.repository.BooksRepository;
import java.util.*;

/**
 *
 * @author RAJAB IMAM
 */
public class Books {
    public static BookModel findBook(String isbn){     
        BooksRepository bookStore = BooksRepository.getInstance();
        BookModel book = bookStore.getBookByIsbn(isbn);
        
        return book;
    }
    
    public ArrayList<BookModel> getAllBook(){
        ArrayList<BookModel> books = new ArrayList<>();
        
        BooksRepository bookStore = BooksRepository.getInstance();
        Hashtable<String,BookModel> allBooks = bookStore.getBooks();
        
        Enumeration<String> e = allBooks.keys();
        
        while (e.hasMoreElements()) {
            // Getting the key of a particular entry
            String key = e.nextElement();
            BookModel book = allBooks.get(key);
            books.add(book);
        }
        
        return books;
    }
}
