/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 886152
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession myHttpSession = request.getSession(false);
        try {
            String userNameSession = myHttpSession.getAttribute("myHttpSession").toString();

            if (userNameSession == null) {

                PrintWriter tmp = response.getWriter();
                tmp.println("<script>alert('in HomeServlet doGet myHttpSession=null');</script>");

//
//                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
//                        .forward(request, response);
            } else {
                PrintWriter tmp = response.getWriter();
                Date CreationTime = new Date(myHttpSession.getCreationTime());

                tmp.println("<script>alert('in HomeServlet doGet myHttpSession=not null" + CreationTime + "');</script>");

                request.setAttribute("showUsername", myHttpSession.getAttribute("myHttpSession"));

                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                        .forward(request, response);
            }

        } catch (Exception ex) {

//            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
//                    .forward(request, response);
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

    }

}
