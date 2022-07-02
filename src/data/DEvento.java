/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import posgresqlconnection.SqlConnection;
import utils.DateString;

/**
 *
 * @author Franklin O. Caceres J.
 */
public class DEvento {
     private SqlConnection connection;

    public DEvento() {
         connection = new SqlConnection("postgres", "root", "127.0.0.1", "5432", "db_tecno_grup26");
    }
     
     
     
     //id, nombre, fecha, horainicio, horafin, ubicacion, descripcion, asunto, idusuario
    public void registrar(String nombre,String fecha,String hora_inicio,String hora_fin, String ubicacion, String descripcion, String asunto, int usuario_id) throws SQLException, ParseException{
     
        String query = "INSERT INTO eventos(nombre, fecha, hora_inicio, hora_fin, ubicacion, descripcion, asunto, usuario_id)" 
                 + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = connection.connect().prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setDate(2, DateString.StringToDateSQL(fecha));
        ps.setTimestamp(3, DateString.StringToTimeSQL(hora_inicio));
        ps.setTimestamp(4, DateString.StringToTimeSQL(hora_fin));
        ps.setString(5, ubicacion);
        ps.setString(6, descripcion);
        ps.setString(7, asunto);
        ps.setInt   (8, usuario_id);
        
        
        if (ps.executeUpdate() == 0) {
            System.out.println("Class DUsuario.java dice: Error al REGISTRAR evento");
            throw new SQLException();
        }
    }
    
        
    public void desconectar(){
        if (connection != null) {
            connection.closeConnection();
        }
    }
}
