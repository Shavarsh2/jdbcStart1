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

public class EditServlet  extends HttpServlet {
    UserServise userServise = new UserServise();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String firstName = req.getParameter("firstname");
       String lastName = req.getParameter("lastname");
       int age = Integer.parseInt(req.getParameter("age"));
       String email1 = null;
       Cookie[] cookies = req.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("email")) {
                email1 = cookie.getValue();
            }
        }
        if(email1 == null){
            throw new RuntimeException();
        }
        try {
            User user = userServise.getByUsername(email1);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAge(age);
            userServise.updateUser(user);
        } catch (NotFoundExeption | InternalServerEror e) {
            throw new RuntimeException(e);
        }

    }

}
