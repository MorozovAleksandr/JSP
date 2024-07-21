package servlet;

import core.model.Operation;
import core.model.User;
import core.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calc")
public class CalcServlet  extends HttpServlet {
    private final OperationService operationService = new OperationService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final double num1 = Double.parseDouble(req.getParameter("num1"));
        final double num2 = Double.parseDouble(req.getParameter("num2"));
        String type = req.getParameter("type");

        User user = (User) req.getSession().getAttribute("user");

        Operation operation = new Operation(num1, num2, type, user.getUsername());

        Operation executedOperation = operationService.execute(operation);

        req.setAttribute("operation", executedOperation);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
