/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author EDER
 */
public class PermisosDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPermisos(Permisos pm){
        String sql ="INSERT INTO permisos (name, iden, job, type, description) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pm.getName());
            ps.setInt(2, pm.getIden());
            ps.setString(3, pm.getJob());
            ps.setString(4, pm.getType());
            ps.setString(5, pm.getDescription());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString()); 
           }
        }
    }
    
    public List ListarPermisos() {
        
        List<Permisos> ListaPm = new ArrayList();
        String sql = "SELECT * FROM permisos";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Permisos pm = new Permisos();
                
                pm.setName(rs.getString("name"));
                pm.setIden(rs.getInt("iden"));
                pm.setJob(rs.getString("job"));
                pm.setType(rs.getString("type"));
                pm.setDescription(rs.getString("description"));
                ListaPm.add(pm);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        
        return ListaPm;
        
    }
       
        public boolean EliminarPermisos(int id){
            String sql = "DELETE FROM permisos WHERE iden = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.execute();
                return true;
                
                
            } catch (SQLException e) {
                
                System.out.println(e.toString());
                return false;
            }finally{
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    
}
