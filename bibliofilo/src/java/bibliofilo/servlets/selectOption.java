package bibliofilo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/selectOption"})
public class selectOption extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String sueldo = request.getParameter("sueldo");
        String select = request.getParameter("select");
        HttpSession session = request.getSession();
        session.setAttribute("sueldo", sueldo);
        if (select.equals("Libros Ultimos 7 Dias")) {
            response.sendRedirect("./1.jsp");
        } else if (select.equals("10% sueldo, Categoria y Estrellas")) {
            response.sendRedirect("./2.jsp");
        } else if (select.equals("Libros Usados, Con 50% sueldo")) {
            response.sendRedirect("./3.jsp");
        } else if (select.equals("Categoria, 20% Sueldo, Autor")) {
            response.sendRedirect("./4.jsp");
        } else if (select.equals("Categoria, Mes y que sea 5 Estrellas")) {
            response.sendRedirect("./5.jsp");
        } else if (select.equals("Categoria, rango de estrellas")) {
            response.sendRedirect("./Extra1.jsp");
        } else if (select.equals("Comming Soon")) {
            response.sendRedirect("./Extra2.jsp");
        } else if (select.equals("Total Autor")) {
            response.sendRedirect("./Extra3.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
