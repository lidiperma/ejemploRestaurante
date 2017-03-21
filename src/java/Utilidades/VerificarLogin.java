
package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class VerificarLogin {
    
    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException{
    
        boolean nRegistro=false; 
        String sql="select * from logeados where usuario='"+usuario+"' AND password='"+password+"'";
        Connection conexion=ConexionRestaurante.conexionRestaurante();
        //PreparedStatement - esto es para preparar la sentencia sql que hemos preparado arriba
        PreparedStatement comprobarLogin=conexion.prepareStatement(sql);
        ResultSet rs=comprobarLogin.executeQuery(sql);// ejecutamos la sentencia con executeQuery
        if(rs.next()){
            //si devuelve resultados el login es correcto
            nRegistro=true;
        }
        
     return nRegistro; 
        

        
        
        
        
        
    }
    
}
