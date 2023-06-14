package am.hitech.jdbc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("test", "123456");
        Cookie cookie1 = new Cookie("test1","aaa");

        cookie.setMaxAge(60*60);
        cookie1.setMaxAge(60*60);

        resp.addCookie(cookie);
        resp.addCookie(cookie1);


    }
}
