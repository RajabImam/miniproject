/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isep.miniproject.repository;

import com.isep.miniproject.models.BookModel;
import java.util.*;

/**
 *
 * @author tobiasodion
 */
public final class BooksRepository {
    private static BooksRepository instance;
    private final Hashtable<String, BookModel> bookStore = new Hashtable<>();
    private final  List<BookModel> books = new ArrayList<>();
    
    private BooksRepository(){     
        books.add(new BookModel("CA123456", "Americanah", "2012", "Chimamanda Adichie", 1));
        books.add(new BookModel("JK345678", "Harry Potter 1", "1995", "J.K Rowling", 1));
        books.add(new BookModel("JG456894", "Pelican Brief", "2014", "John Grishan", 0));
        books.add(new BookModel("SA145045", "Everything Good will Come", "2006", "Sefi Atta", 1));

       for (BookModel book : books){   
           if(this.bookStore.containsKey(book.getIsbn()) == false){
               this.bookStore.put(book.getIsbn(),book);
           }  
       }
    }
    
    public static BooksRepository getInstance() {
        if (instance == null) {
            instance = new BooksRepository();
        }
        return instance;
    }
    
    public Hashtable<String, BookModel> getBooks(){
        return this.bookStore;
    }
    
    public int addBook(BookModel book){
        if(bookStore.containsKey(book.getIsbn())){
            return 0;
        }
        
        bookStore.put(book.getIsbn(), book); 
        return 1;
    }
    
    public BookModel getBookByIsbn(String isbn){
        if(bookStore.containsKey(isbn)){
            return bookStore.get(isbn);
        }
        
        return null;
    }
}
