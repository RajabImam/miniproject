/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isep.miniproject.controllers;

import com.isep.miniproject.dao.Authentication;
import com.isep.miniproject.dao.Books;
import com.isep.miniproject.models.AuthenticationModel;
import com.isep.miniproject.models.BookModel;
import com.isep.miniproject.models.WelcomeViewModel;
import com.isep.miniproject.repository.BooksRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RAJAB IMAM
 */
public class AuthServlet extends HttpServlet {

    static BooksRepository bookStore;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        HttpSession session = request.getSession(false);
        if (session != null) {
            //session.invalidate();
            session.setAttribute("ErrMessage ", " You have logged out successfully");
            request.getRequestDispatcher("/goodbye.jsp").forward(request, response);
        }
        
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
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        AuthenticationModel authModel = new AuthenticationModel();
        authModel.setLogin(login);
        authModel.setPassword(password);
        
        Authentication auth = new Authentication();
        
        String userValidation = auth.userAuthentication(authModel);
        if (userValidation.equals("SUCCESS")) {
            request.setAttribute("login", login);
            session.setAttribute("login", login);
            
            //initialize bookstore
            bookStore = BooksRepository.getInstance();
            
            //get a list of all books from repository 
            Books books = new Books();
            ArrayList<BookModel> result = books.getAllBook();
                    
            //add books to the view model
            WelcomeViewModel welcomeView = new WelcomeViewModel(result);
            
            //set a session variable to store the list of books
            session.setAttribute("welcomeView", welcomeView);
            //resirect to welcome page
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
            request.setAttribute("ErrMessage", userValidation);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
