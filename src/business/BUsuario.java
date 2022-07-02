/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.DUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franklin O. Caceres J.
 */
public class BUsuario {
    private DUsuario dUsuario;

    public BUsuario() {
        dUsuario = new DUsuario();
    }
    
    public void registrar(List<String> parametros) throws SQLException{
        
        //TODO verificar si existe correo
        dUsuario.registrar(parametros.get(0), parametros.get(1), parametros.get(2),parametros.get(3));
        dUsuario.desconectar();
    }
    
    public void modificar(List<String> parametros) throws SQLException{
        dUsuario.modificar(Integer.parseInt(parametros.get(0)), parametros.get(1), parametros.get(2),parametros.get(3), parametros.get(4));
        dUsuario.desconectar();
    }
    
    public void eliminar(List<String> parametros) throws SQLException{
        dUsuario.eliminar(Integer.parseInt(parametros.get(0)));
        dUsuario.desconectar();
    }
    
    public ArrayList<String[]> listar() throws SQLException {
        
        ArrayList<String[]> usuarios = (ArrayList<String[]>) dUsuario.listar();
        dUsuario.desconectar();
        return usuarios;
    }
}
