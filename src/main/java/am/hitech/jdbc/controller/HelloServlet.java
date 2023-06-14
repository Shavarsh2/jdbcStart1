package am.hitech.jdbc.controller;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.service.UserServise;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    UserServise servise = new UserServise();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
     // String name = req.getParameter("name");
     // String s = req.getParameter("surname");
     // printWriter.write("hello" + name + " " + s);
        Integer a = Integer.parseInt(req.getParameter("id"));
        User user = null;
        try {
            user = servise.getById(a);
        } catch (NotFoundExeption e) {
            throw new RuntimeException(e);
        } catch (InternalServerEror e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(user.toString());

    }
}
