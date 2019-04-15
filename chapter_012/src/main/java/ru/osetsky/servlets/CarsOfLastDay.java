package ru.osetsky.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CarsOfLastDay {
    private static final Logger LOG = LoggerFactory.getLogger(CarList.class);
    private final ValidateService logic = ValidateService.getInstance();
    private String lastRequest = null;


    @RequestMapping(value = "/lastday", method = RequestMethod.GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getHeader("brand"));
        if (request.getHeader("brand") != null) {
            lastRequest = request.getHeader("brand");
        }
        if (lastRequest.equals("All")) {
            request.setAttribute("cars",logic.getAllCars());
        } else {
            request.setAttribute("cars", logic.findCarsByMark(lastRequest));
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/CarList.jsp");
        requestDispatcher.forward(request, response);
    }
}
