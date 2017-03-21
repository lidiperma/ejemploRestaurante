
package dao.restaurante.cocinero;

import Utilidades.ConexionRestaurante;
import static Utilidades.ConexionRestaurante.masterChef;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DaoCocinero {
    
    public static ResultSet verCocinero() throws ClassNotFoundException, SQLException{

   
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idcocinero,nombre,apellido from cocinero";
    ResultSet lista_cocineros=sentencia.executeQuery(consultaSQL);
    return lista_cocineros;
}





public static void insertarCocinero(int idcocinero, String nombre, String apellido) throws ClassNotFoundException, SQLException {
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into cocinero (idcocinero,nombre,apellido) values ";
    consultaSQL += "('" + idcocinero + "','" + nombre + "','" + apellido + "')";
    sentencia.executeUpdate(consultaSQL);
    sentencia.close();
  

}
public static void procesarPeticionCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{

    masterChef =new Cocinero();
    masterChef.setIdcocinero(Integer.parseInt(request.getParameter("idcocinero")));
    masterChef.setNombre(request.getParameter("nombre"));
    masterChef.setApellido(request.getParameter("apellido"));
    insertarCocinero(masterChef.getIdcocinero(), masterChef.getNombre(), masterChef.getApellido());
    response.sendRedirect("/Restaurante/mostrarServletCocinero");

}

    public static ResultSet verCocineros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
