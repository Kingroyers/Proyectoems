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
public class NominaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarNomina(Nomina nm) {
    
    String sql = "INSERT INTO nomina (name, iden, job, salary, commissions, bonuses, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try {
        
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nm.getName());
        ps.setInt(2, nm.getIden());
        ps.setString(3, nm.getJob());
        ps.setInt(4, nm.getSalary());
        ps.setInt(5, nm.getCommissions());
        ps.setInt(6, nm.getBonuses());
        ps.setInt(7, nm.getTotal());
        ps.execute();
        return true;
        
    } catch (SQLException e) {
        
        JOptionPane.showMessageDialog(null, e.toString());
        return false;
        
    } finally {
        
        try {
            
            con.close();
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        
    }
}
    
    public List ListarNomina() {
        
        List<Nomina> ListaNm = new ArrayList();
        String sql = "SELECT * FROM nomina";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Nomina nm = new Nomina();
                nm.setName(rs.getString("name"));
                nm.setIden(rs.getInt("iden"));
                nm.setJob(rs.getString("job"));
                nm.setSalary(rs.getInt("salary"));
                nm.setCommissions(rs.getInt("commissions"));
                nm.setBonuses(rs.getInt("bonuses"));
                nm.setTotal(rs.getInt("total"));
                ListaNm.add(nm);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        
        return ListaNm;
        
    }
    
    public boolean EliminarNomina (int id) {
        
        String sql = "DELETE FROM nomina WHERE iden = ?";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            return false;
        }
        
        finally {
            
            try {
                
                con.close();
                
            } catch (SQLException ex) {
                
                System.out.println(ex.toString());
                
            }
            
        }
        
    }
        
    }
    

