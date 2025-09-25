package ru.itis.kpfu.sorokin.server;

import ru.itis.kpfu.sorokin.repository.InMemoryUserRepository;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String loginInput = req.getParameter("login");
        String passwordInput = req.getParameter("password");
        boolean flag = false;

        for (var entry : InMemoryUserRepository.getAllUsers().entrySet()) {
            String login = entry.getKey();
            String password = entry.getValue();

            if (login.equalsIgnoreCase(loginInput) && password.equalsIgnoreCase(passwordInput)) {

                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user", login);
                httpSession.setMaxInactiveInterval(60 * 60);

                // cookie
                Cookie cookie = new Cookie("user", login);
                cookie.setMaxAge(24 * 60 * 60);

                resp.addCookie(cookie);

                resp.sendRedirect("main.jsp");
                flag = true;
            }
        }

        if (!flag) {
            resp.sendRedirect("/login");
        }

    }

}