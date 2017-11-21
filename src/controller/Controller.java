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
        HttpSession session = req.getSession();

        String method = req.getParameter("method");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService();

        Set<Gem> gemSet;
        if((gemSet = (Set<Gem>) session.getAttribute("gemSet") ) == null) {
            gemSet = service.parseXML(method, PATH);
            session.setAttribute("gemSet", gemSet);
        }
        buildPagination(gemSet,req,resp);
    }

    private void buildPagination(Set<Gem> gemSet, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int page = 1;
        int recordsPerPage = 5;
        if(req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));
        }
        int firstElement = (page-1)*recordsPerPage;
        int lastElement = firstElement+recordsPerPage-1;

        Set<Gem> gemSetToPage =  ServiceImpl.getRecords(gemSet,firstElement, lastElement);
        int countRecords = gemSet.size();
        int countPages = (int) Math.ceil(countRecords* 1.0 / recordsPerPage);

        req.setAttribute("gemSetToPage",gemSetToPage);
        req.setAttribute("countPages", countPages);
        req.setAttribute("currentPage", page);

        req.getRequestDispatcher("table.jsp").forward(req,resp);
    }
}
