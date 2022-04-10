/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isep.miniproject.controllers;

import com.isep.miniproject.models.BookModel;
import com.isep.miniproject.repository.BooksRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tobiasodion
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/InitServlet"})
public class InitServlet extends HttpServlet {
    
    static BooksRepository bookStore;
    
    /**
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException
    {
        bookStore = BooksRepository.getInstance();
    }
}
