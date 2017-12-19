package controller;

import entity.Gem;
import service.Service;
import service.ServiceFactory;
import service.impl.ServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * Created by DNAPC on 14.11.2017.
 */
public class Controller extends HttpServlet {
    public static final String PATH = "D:\\Documents\\Java\\WEB\\Task3.3\\Task3.3\\resources\\test.xml";
    public static final int RECORDS_PER_PAGE = 7;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String method = req.getParameter("method");
        int page = 1; //default page
        if(req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));
        }
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService();
        Set<Gem> gemSet = service.parseXML(method, PATH);
        Set<Gem> gemSetToPage =  service.getRecords(gemSet,page, RECORDS_PER_PAGE);
        int countRecords = gemSet.size();
        int countPages = (int) Math.ceil(countRecords* 1.0 / RECORDS_PER_PAGE);

        req.setAttribute("gemSetToPage",gemSetToPage);
        req.setAttribute("countPages", countPages);
        req.setAttribute("currentPage", page);
        req.setAttribute("method", method);

        req.getRequestDispatcher("table.jsp").forward(req,resp);
    }

}
