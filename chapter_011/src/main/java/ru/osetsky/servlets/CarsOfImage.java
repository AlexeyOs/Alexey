package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarsOfImage extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CarList.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String lastRequest = null;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getHeader("image"));
        if (request.getHeader("image") != null) {
            lastRequest = request.getHeader("image");
        }
        if (lastRequest.equals("All")) {
            request.setAttribute("cars",logic.getAllCars());
        } else {
            request.setAttribute("cars", logic.checkImage(lastRequest));
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/CarList.jsp");
        requestDispatcher.forward(request, response);
    }
}
