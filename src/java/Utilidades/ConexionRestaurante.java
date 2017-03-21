
package Utilidades;

import entidades.Camarero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public  class ConexionRestaurante {
    
private static Connection conexion;

public static Camarero camata;
public static Cocinero masterChef;

//este metodo devuelve un objeto de tipo conexion
public static Connection conexionRestaurante() throws ClassNotFoundException, SQLException{
    
    String classname="com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/restaurante";
                String user = "root";
                String password = "root";
    
    Class.forName(classname);
    conexion=DriverManager.getConnection(url,user,password);
    
    if(conexion !=null){
        
        System.out.println("Conexion establecida");
    } else{
        
        System.out.println("Conexion abortada");
    }
    return conexion;
}





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
    String consultaSQL = "insert into camarero (idcocinero,nombre,apellido) values ";
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

 public static void cerrarConexion() throws ClassNotFoundException, SQLException{
     if(conexion!=null){
     conexion.close();
     System.out.println("Conexion Cerrada");
     }
else{
    System.out.println("Se ha producido un error");
}
} 

    public static ResultSet verCamareros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ResultSet verCocineros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void procesarPeticion(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
 
 

   

}