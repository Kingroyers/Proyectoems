
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    Connection con;
    
    public Connection getConnection() {
        
        try {
            
            String myBD = "jdbc:mysql://localhost:3306/ems?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString()); //**para imprimir error en consola**//
            
        }
        return null;
    }
    
}
