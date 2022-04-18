/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.isep.miniproject.controllers;

import static com.isep.miniproject.controllers.AuthServlet.bookStore;
import com.isep.miniproject.dao.Books;
import com.isep.miniproject.models.BookModel;
import com.isep.miniproject.models.WelcomeViewModel;
import com.isep.miniproject.repository.BooksRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tobiasodion
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class WelcomeServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
        //initialize bookstore
            bookStore = BooksRepository.getInstance();
            
            //get a list of all books from repository 
            ArrayList<BookModel> result = Books.getAllBook();
                    
            //add books to the view model
            WelcomeViewModel welcomeView = new WelcomeViewModel(result);
            
            //set a session variable to store the list of books
            session.setAttribute("welcomeView", welcomeView);
           
            //resirect to welcome page
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
