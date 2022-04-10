/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.isep.miniproject.repository;

import org.junit.*;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import java.util.*;
import com.isep.miniproject.models.BookModel;
/**
 *
 * @author tobiasodion
 */
public class BooksRepositoryTest {
    
    static BooksRepository testBooksRepository;
    
    @BeforeClass
    public static void setUpClass() {
        testBooksRepository = BooksRepository.getInstance();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void initializationDoesNotRepeatIsbn() {
        Hashtable<String, BookModel> testBookStore = testBooksRepository.getBooks();
        assertEquals(4, testBookStore.size());
    }
    
}
