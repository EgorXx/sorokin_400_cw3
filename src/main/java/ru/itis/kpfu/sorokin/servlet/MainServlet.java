package ru.itis.kpfu.sorokin.servlet;

import ru.itis.kpfu.sorokin.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String sessionUser = (String) session.getAttribute("user");
        if (sessionUser == null) {
            resp.sendRedirect("/login");
        }

        String cookieUser = "";
        String sessionId = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equalsIgnoreCase(c.getName())) {
                    cookieUser = c.getValue();
                } else if ("jsessionid".equalsIgnoreCase(c.getName())) {
                    sessionId = c.getValue();
                }
            }
        } else {
            sessionId = session.getId();
        }

        req.setAttribute("sessionUser", sessionUser);
        req.setAttribute("sessionId", sessionId);
        req.setAttribute("cookieUser", cookieUser);
        req.getRequestDispatcher("main.ftl").forward(req, resp);
    }
}
