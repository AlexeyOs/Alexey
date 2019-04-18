package ru.osetsky.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.osetsky.servlets.CarList;
import ru.osetsky.servlets.ValidateService;

import javax.servlet.http.HttpServletRequest;

public class FilterCarsByImage {
    private static final Logger LOG = LoggerFactory.getLogger(CarList.class);
    private static final ValidateService logic = ValidateService.getInstance();
    private static String lastRequest = null;

    public static HttpServletRequest getFilterCarsByImage (HttpServletRequest request){
        LOG.info(request.getHeader("image"));
        if (request.getHeader("image") != null) {
            lastRequest = request.getHeader("image");
        }
        if (lastRequest.equals("All")) {
            request.setAttribute("cars",logic.getAllCars());
        } else {
            request.setAttribute("cars", logic.checkImage(lastRequest));
        }
        return request;
    }
}
