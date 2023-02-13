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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ifInValidate = request.getParameter("invalidate");
        try {
            String myHttpSession = request.getSession().getAttribute("myHttpSession").toString();

            if (myHttpSession != null) {
                if (ifInValidate != null && ifInValidate.equals("yes")) {

//                    PrintWriter tmp = response.getWriter();
//                    tmp.println("<script>alert('in ifinvalidat =yes');</script>");
                    request.getSession(false).invalidate();
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                            .forward(request, response);
                } else {

                    request.setAttribute("showUsername", request.getSession().getAttribute("myHttpSession"));
                    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                            .forward(request, response);
                }
            } else {
            }

        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        };

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inputUsername = request.getParameter("username");
        String inputPassword = request.getParameter("userpassword");

        if (inputUsername == null || inputUsername.length() <= 0) {
            request.setAttribute("message", "Input error, please check and refill it.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else {
            AccountService loginAccountVerify = new AccountService();

            User loginUser = loginAccountVerify.login(inputUsername, inputPassword);

            if (loginUser == null) {
                request.setAttribute("username", loginUser);
                request.setAttribute("message", "Failed authentication.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            } else {
                HttpSession myHttpSession = request.getSession();
                myHttpSession.setAttribute("myHttpSession", loginUser.getUsername());

                request.setAttribute("showUsername", request.getSession().getAttribute("myHttpSession"));
                getServletContext().getRequestDispatcher("/WEB-INF/home.jsp")
                        .forward(request, response);
            };

        }

    }

}
