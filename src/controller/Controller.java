package controller;

import entity.Entity;
import service.Service;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class Controller extends HttpServlet {
    public static final String PATH = null;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String method = req.getParameter("method");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService();

        List<Entity> entities = null;
        if (method.equals("SAX")) {
            entities = service.SAXParse(PATH);
        }
        if (method.equals("StAX")) {
            entities = service.StAXParse(PATH);
        }
        if (method.equals("DOM")) {
            entities = service.DOMParse(PATH);
        }
        req.setAttribute("entities",entities);
    }
}
