/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import posgresqlconnection.SqlConnection;

/**
 *
 * @author Franklin O. Caceres J.
 */
public class DUsuario {
    private SqlConnection connection;
    

    public DUsuario() {
        connection = new SqlConnection("postgres", "root", "127.0.0.1", "5432", "db_tecno_grup26");
    }
    
    //id, nombre, correo, contraseña, rol
    public void registrar(String nombre,String correo,String contrasena,String rol) throws SQLException{
     
        String query = "INSERT INTO usuarios(nombre, correo, contrasena, rol)" 
                 + "values(?, ?, ?, ?)";
        
        PreparedStatement ps = connection.connect().prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, contrasena);
        ps.setString(4, rol);
        
        if (ps.executeUpdate() == 0) {
            System.out.println("Class DUsuario.java dice: Error al REGISTRAR usuario");
            throw new SQLException();
        }
    }
    
    public void modificar(int id, String nombre,String correo,String contrasena,String rol) throws SQLException{
        
        String query = "UPDATE usuarios SET nombre=?, correo=?, contrasena=?, rol=?"
                +"WHERE id = ?";
        
         PreparedStatement ps = connection.connect().prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, contrasena);
        ps.setString(4, rol);
        ps.setInt(5, id);
        
        if (ps.executeUpdate() == 0) {
            System.out.println("Class DUsuario.java dice: Error al MODIFICAR usuario");
            throw new SQLException();
        }
        
    }
    
    public void eliminar( int id) throws SQLException{
        
        String query = "DELETE FROM usuarios WHERE id = ?";
        
        PreparedStatement ps = connection.connect().prepareStatement(query);
        
        ps.setInt(1, id);
        
         if (ps.executeUpdate() == 0) {
            System.out.println("Class DUsuario.java dice: Error al ELIMINAR usuario");
            throw new SQLException();
        }
        
    }
    
    public List<String[]> listar() throws SQLException{
        List<String[]> usuarios = new ArrayList<>();
        
        String query = "SELECT * FROM usuarios";
        
        PreparedStatement ps = connection.connect().prepareStatement(query);
        
        ResultSet set = ps.executeQuery();
        
        while(set.next()){
            usuarios.add(new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("nombre"),
                set.getString("correo"),
                set.getString("rol"),
            });
        }
        
        return usuarios;
    }
    
    public String[] ver(int id) throws SQLException{
        
        String[] usuario = null;
        
        String query = "SELECT *FROM usuarios WHERE id=?";
        PreparedStatement ps = connection.connect().prepareStatement(query);
        ps.setInt(1, id);
        
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            usuario = new String[]{
                String.valueOf(set.getInt("id")),
                set.getString("nombre"),
                set.getString("correo"),
                set.getString("rol"),
            };
        }
         
        return usuario;
    } 
    
    public int buscarUsuarioPorCorreo(String correo) throws SQLException{
        
        int id = -1;
        String query = "SELECT *FROM usuarios WHERE correo=?";
        PreparedStatement ps = connection.connect().prepareStatement(query);
        ps.setString(1, correo);
        
        ResultSet set = ps.executeQuery();
        if (set.next()) {
            id= set.getInt("id");
        }
        
        return id;
    }
    
    public void desconectar(){
        if (connection != null) {
            connection.closeConnection();
        }
    }
}
