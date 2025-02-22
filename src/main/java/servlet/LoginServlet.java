package servlet;

import core.model.User;
import core.service.UserService;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login", name="LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService(new InMemoryUserStorage());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        req.setAttribute("username", username);

        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");

        Optional<User> login = userService.login(username, password);
        if(login.isPresent()) {
            User user = login.get();
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "User not found");
            getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }
    }
}
