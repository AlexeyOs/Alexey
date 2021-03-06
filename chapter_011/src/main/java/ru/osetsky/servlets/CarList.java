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

        request.setAttribute("cars", logic.getAllCars());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/CarList.jsp");
        requestDispatcher.forward(request, response);
    }
}
