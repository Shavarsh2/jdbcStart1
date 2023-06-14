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
import java.util.Random;

public class UpdatePassServlet extends HttpServlet {
    UserServise userServise = new UserServise();
    private static String rand = rand(6);

    public static String getRand() {
        return rand;
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String email = req.getParameter("username");
        try {
            User user = userServise.getByUsername(email);
            if (user == null) {
                printWriter.write("wrong email");
            } else {
                user.setPassToken(rand);
                userServise.updateUser(user);
                printWriter.write("ok");
            }
        } catch (NotFoundExeption | InternalServerEror e) {
            printWriter.write("wrong email");
        }
    }

    private static String rand(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }
}
