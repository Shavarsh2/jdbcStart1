package am.hitech.jdbc.controller;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.service.UserServise;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    UserServise userServise = new UserServise();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("username");
        String pass = req.getParameter("password");
        Cookie cookie = new Cookie("email",userName);
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        try {
            User user = userServise.getByUsername(userName);
            resp.sendRedirect("editUser.html");
        } catch (NotFoundExeption | InternalServerEror e) {
            printWriter.write("wrong username or password");
        }
    }
}
