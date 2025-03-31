package conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    public static Connection getConexion() {
        Connection cn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/la_casa_de_los_lentes", "root", "root");
            
            System.out.print("Conexion satisfactoria");
        } catch (Exception e) {
            System.out.print("Error de Conexion");
        }
        return cn;
    }
    
    public static void main(String[] args) {
        getConexion();
    }
    
}
