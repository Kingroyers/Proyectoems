
package Modelo;

import java.sql.ResultSet;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antonio
 */
public class EmpleadosDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpleados(Empleados em){
        String sql ="INSERT INTO empleados (name, iden,	phone,	email, address, job, hire, start, end) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql); // para consultas sql
            
            ps.setString(1, em.getName());
            ps.setInt(2, em.getIden());
            ps.setInt(3, em.getPhone());
            ps.setString(4, em.getEmail());
            ps.setString(5, em.getAddress());
            ps.setString(6, em.getJob());
            ps.setString(7, em.getHire());
            ps.setString(8, em.getStart());
            ps.setString(9, em.getEnd());
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
    
    public List ListarEmpleados() {
        
        List<Empleados> ListaEm = new ArrayList(); // ArrayList proporciona una variedad de métodos 
        String sql = "SELECT * FROM empleados";    //para agregar, eliminar, buscar y manipular elementos en la lista, incluyendo add(), remove(), get(), indexOf(), size(), entre otros. 
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Empleados em = new Empleados();
                
                em.setId(rs.getInt("id"));
                em.setName(rs.getString("name"));
                em.setIden(rs.getInt("iden"));
                em.setPhone(rs.getInt("phone"));
                em.setEmail(rs.getString("email"));
                em.setAddress(rs.getString("address"));
                em.setJob(rs.getString("job"));
                em.setHire(rs.getString("hire"));
                em.setStart(rs.getString("start"));
                em.setEnd(rs.getString("end"));
                ListaEm.add(em);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.toString()); //mostrar error en consola//
            
        }
        
        return ListaEm;
        
    }
       
        public boolean EliminarEmpleados(int id){
            String sql = "DELETE FROM empleados WHERE id = ?";
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
                
        public boolean ModificarEmpleados(Empleados em){
            String sql = "UPDATE empleados SET name=?, iden=?, phone=?, email=?, address=?, job=?, hire=?, start=?, end=? WHERE id=?";
         
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                
                ps.setString(1, em.getName());
                ps.setInt(2, em.getIden()); 
                ps.setInt(3, em.getPhone());
                ps.setString(4, em.getEmail());
                ps.setString(5, em.getAddress());
                ps.setString(6, em.getJob());
                ps.setString(7, em.getHire());
                ps.setString(8, em.getStart());
                ps.setString(9, em.getEnd());
                ps.setInt(10, em.getId());
                ps.execute();
                return true;
                
            } catch (SQLException e) {
                System.out.println(e.toString());
                return false;
            }finally{
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.toString());
                }
            }
            
                    
        }
        
          
         public DefaultTableModel BuscarEmpleados(String buscar) {

        int contador = 1;
        String[] nombresColumnas = {"ID", "NAME", "IDEN", "PHONE", "EMAIL", "ADDRESS", "JOB", "HIRE", "START", "END"};
        String[] registros = new String[10];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM empleados WHERE iden LIKE "+buscar+"";

        
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = Integer.toString(contador);
                registros[1] = rs.getString("name");
                registros[2] = rs.getString("iden");
                registros[3] = rs.getString("phone");
                registros[4] = rs.getString("email");
                registros[5] = rs.getString("address");
                registros[6] = rs.getString("job");
                registros[7] = rs.getString("hire");
                registros[8] = rs.getString("start");
                registros[9] = rs.getString("end");

                modelo.addRow(registros);

                contador++;
                

            }

        } catch (SQLException e) {

            System.out.println(e.toString());
            

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e.toString());

            }

        }
        return modelo;
    }
    }

