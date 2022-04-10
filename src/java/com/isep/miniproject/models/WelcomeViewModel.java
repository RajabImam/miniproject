/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isep.miniproject.models;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author tobiasodion
 */
public class WelcomeViewModel implements Serializable {
    private ArrayList<BookModel> books;
    
    public WelcomeViewModel(ArrayList<BookModel> books){
        this.books = books;
    }
    
    public WelcomeViewModel(){
        
    }
    
    public ArrayList<BookModel> getBooks(){
        return this.books;
    }
    
    public void setBooks(ArrayList<BookModel> books){
        this.books = books;
    }
}
