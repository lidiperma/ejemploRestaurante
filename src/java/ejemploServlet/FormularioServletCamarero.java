package ejemploServlet;

import Utilidades.ConexionRestaurante;
import dao.restaurante.camarero.DaoCamarero;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet(name="FormularioServletCamarero", urlPatterns={"/Restaurante/formularioServletCamarero"})
public class FormularioServletCamarero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

                
            HttpSession misession = (HttpSession) request.getSession();
            String usuarioLogeado=(String) misession.getAttribute("user");
            String usuarioPass=(String) misession.getAttribute("pass");
            
            
            if(usuarioLogeado.contains("root") && usuarioPass.contains("root")){
                
                DaoCamarero.procesarPeticionCamarero(request, response);
            
            }else{
                response.sendRedirect("/Restaurante/Principal.html");
            }
            
    
    
            
               
                //Statement sentencia = null;
                //Connection conexion;
                //recuperamos los parametros del form, y los guardamos en variables
                //que utilizaremos para la insercion en la BD
               // String idCamarero = request.getParameter("idcamarero");
                //String nombre = request.getParameter("nombre");
                //String apellido = request.getParameter("apellido");
                
                //ConexionRestaurante.procesarPeticionCamarero(request, response);
                
                //conexion=ConexionRestaurante.conexionRestaurante();
                //ConexionRestaurante.insertarCamarero(idCamarero, nombre, apellido);
                 
                //sentencia = conexion.createStatement();
                
                
                //String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
                //consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "')";
                
                //--Ejecutar consulta que no devuelve resultados
                //sentencia.executeUpdate(consultaSQL);
                //sentencia.close();
               
                //response.sendRedirect("/Restaurante/mostrarServletCamarero");
                 //Aqui empiezar la response de este Servlet
                /*response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    /*out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet FormularioServletCamarero</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Datos Insertados</h1>");
                    out.println("<h1>Datos Insertados:" + idCamarero + "</h1>");
                    out.println("<h1>Datos Insertados:" + nombre + "</h1>");
                    out.println("<h1>Datos Insertados:" + apellido + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                }*/
            } 
         
        
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FormularioServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FormularioServletCamarero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

