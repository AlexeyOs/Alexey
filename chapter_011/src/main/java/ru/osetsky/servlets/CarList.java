package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.models.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarList extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CarList.class);
    private final ValidateService logic = ValidateService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Car book = logic.getById(11);

        request.setAttribute("cars", logic.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/CarList.jsp");
        requestDispatcher.forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
////        List<Car> cars = logic.getAll();
//        getServletContext().setAttribute("car", logic.getById(11));
//        req.getRequestDispatcher("/CarList.jsp").forward(req, resp);
//    }
}
