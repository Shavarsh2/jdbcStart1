package am.hitech.jdbc.controller;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.ModelFormExeption;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.Adress;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.service.AdressServise;
import am.hitech.jdbc.service.UserServise;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatServlet extends HttpServlet {
    UserServise servise = new UserServise();
    AdressServise adressServise = new AdressServise();

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String lastname = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String email = req.getParameter("username");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String pass = req.getParameter("password");
        String pass1 = req.getParameter("password1");
        String country = req.getParameter("country");
        String sity = req.getParameter("sity");
        String street = req.getParameter("street");
        Integer home = Integer.parseInt(req.getParameter("home"));

        User user = new User(firstName, lastname, email, age, pass1);

        try {
            if (pass.equals(pass1)) {
                servise.creatUserV2(user);
                User user1 = new User();
                user1 = servise.getByUsername(email);
                Adress adress = new Adress(0, country, sity, street, home, user1.getId());
                adressServise.creatAdress(adress);
                printWriter.write("creat");
            } else {
                printWriter.write("wrong password");
            }
        } catch (InternalServerEror e) {
            printWriter.write("erorr");
        } catch (ModelFormExeption e) {
            printWriter.write("model eror");
        } catch (NotFoundExeption e) {
            printWriter.write("name exits");
        }
    }
}
