
package dao.restaurante.camarero;

import Utilidades.ConexionRestaurante;
import static Utilidades.ConexionRestaurante.camata;
import entidades.Camarero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DaoCamarero {
    
    public static void insertarCamarero(String idCamarero,String nombre,String apellido) throws SQLException, ClassNotFoundException{
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia=conexion.createStatement();
    String consultaSQL = "insert into camarero (idcamarero,nombre,apellido) values ";
    consultaSQL += "('" + idCamarero + "','" + nombre + "','" + apellido + "')";
    //sentencia.executeUpdate(consultaSQL);
    int filas=sentencia.executeUpdate(consultaSQL);
    System.out.println("Numero de filas insertadas:"+filas);
    sentencia.close();
    ConexionRestaurante.cerrarConexion();
    //conexion.close();
    
}
    
    public static ResultSet verCamareros() throws ClassNotFoundException, SQLException{
    
      Connection conexion=ConexionRestaurante.conexionRestaurante();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idcamarero,nombre,apellido from camarero";
      ResultSet lista_camareros=sentencia.executeQuery(consultaSQL);
      return lista_camareros;
    
    
}
    //pasara a ser una clase de negocio
    public static void procesarPeticionCamarero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
    //orientacion a objetos
    camata=new Camarero();
    camata.setIdCamarero(request.getParameter("idcamarero"));
    camata.setNombre(request.getParameter("nombre"));
    camata.setApellido(request.getParameter("apellido"));
    insertarCamarero(camata.getIdCamarero(), camata.getNombre(), camata.getApellido());
    response.sendRedirect("/Restaurante/mostrarServletCamarero");

}
    
  //faltan metodos update y delete  
    
}
