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

public class ChangePassServlet extends HttpServlet {
    UserServise userServise = new UserServise();
    private  String token = UpdatePassServlet.getRand();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String pass = req.getParameter("password");
        String pass1 = req.getParameter("password1");
        if (pass.equals(pass1)) {
            try {
                User user1 = userServise.getbyPassToken(token);
                user1.setPassword(pass);
                userServise.updateUserPass(user1);
                printWriter.write("password is changed");
            } catch (InternalServerEror | NotFoundExeption e) {
                printWriter.write("wrong token");
            }
        }
         else {
            printWriter.write("wrong password");
        }
    }
}
