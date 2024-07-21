package servlet;

import core.model.Operation;
import core.model.User;
import core.service.OperationService;
import storage.InMemoryOperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private final OperationService operationService = new OperationService(new InMemoryOperationStorage());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        Optional<List<Operation>> historyOperations = operationService.getAllOperations(user.getUsername());

        if (historyOperations.isPresent()) {
            req.setAttribute("operations", historyOperations.get());
        } else {
            req.setAttribute("operations", new ArrayList<Operation>());
        }

        getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
