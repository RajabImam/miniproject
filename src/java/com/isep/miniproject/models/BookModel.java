/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isep.miniproject.models;

import java.io.*;

/**
 *
 * @author tobiasodion
 */
public class BookModel implements Serializable {
    private String isbn;
    private String bookTitle;
    private String releaseYear;
    private String author;
    private int status; //1 - available, 0 - unavailable
    
    public BookModel(){
        
    }
    
    public BookModel(String isbn, String bookTitle, String releaseYear, String author, int status){
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.author = author;
        this.releaseYear = releaseYear;
        this.status = status;
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    
     public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    
    public String getBookTitle(){
        return this.bookTitle;
    }
    
     public void setReleaseYear(String releaseYear){
        this.releaseYear = releaseYear;
    }
    
    public String getReleaseYear(){
        return this.releaseYear;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public int getStatus(){
        return this.status;
    }
}
