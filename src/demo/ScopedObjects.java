package demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ScopedObjects")
public class ScopedObjects extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public ScopedObjects() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request scope
        req.setAttribute("test","Hello");
        String test = (String) req.getAttribute("test");

        // Session scope
        HttpSession session = req.getSession();
        session.setAttribute("test","Hello");
        String test1 = (String) session.getAttribute("test");

        // Application scope
        ServletContext context = getServletContext();
        context.setAttribute("test","Hello");
        String test2 = (String) context.getAttribute("test");
    }
}
