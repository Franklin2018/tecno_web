/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.DEvento;
import data.DUsuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Franklin O. Caceres J.
 */
public class BEvento {
    
    private DEvento dEvento;
    private DUsuario dUsuario;

    public BEvento() {
        dEvento = new DEvento();
        dUsuario = new DUsuario();
    }
    
    
    public void registrar(List<String> parametros, String correo) throws SQLException, ParseException{
        int usuarioId = dUsuario.buscarUsuarioPorCorreo(correo);
        
        if (usuarioId != -1) {
            dEvento.registrar(parametros.get(0), parametros.get(1), parametros.get(2), 
                    parametros.get(3), parametros.get(4), parametros.get(5), 
                    parametros.get(6), usuarioId);
            dEvento.desconectar();
        }
        dUsuario.desconectar();
    }
}
