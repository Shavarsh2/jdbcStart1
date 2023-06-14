package am.hitech.jdbc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<body>");
        for(Cookie cookie : cookies){
            printWriter.write("<h1>" + cookie.getName() + ": " + cookie.getValue() + "</h1>");
        }
        printWriter.write("</body>");

    }
}
