package servlet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import core.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private String password;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<User> user = Optional.ofNullable((User) req.getSession().getAttribute("user"));

        if (user.isPresent()) {
            getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }
}
