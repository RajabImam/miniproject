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

            //Redirect to welcome servlet
            response.sendRedirect("WelcomeServlet");
        } else {
            request.setAttribute("ErrMessage", userValidation);
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
