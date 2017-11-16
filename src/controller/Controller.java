package controller;

import entity.Gem;
import service.Service;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class Controller extends HttpServlet {
    public static final String PATH = "resources/gems.xml";

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

        Set<Gem> entities = null;
        entities = service.parseXML(method,PATH);

        req.setAttribute("entitySet",entities);
        req.getRequestDispatcher("table.jsp").forward(req,resp);
    }
}
