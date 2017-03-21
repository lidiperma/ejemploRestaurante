
package ejemploServlet;

import Utilidades.ConexionRestaurante;
import dao.restaurante.cocinero.DaoCocinero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mostrarServletCocinero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        ResultSet lista_cocineros=DaoCocinero.verCocineros();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mostrarServletCocinero</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Mostrar Cocineros " + request.getContextPath() + "</h1>");
            while(lista_cocineros.next()){
              
           out.println("<p>ID camero: "+lista_cocineros.getString(1)+"</p>");
           out.println("<p> Nombre"+lista_cocineros.getString(2)+"</p>");
           out.println("<p> Apellido"+lista_cocineros.getString(3)+"</p>");
              
           } 
           
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(mostrarServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(mostrarServletCocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
