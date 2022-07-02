/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessdata;

import business.BEvento;
import business.BUsuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin O. Caceres J.
 */
public class BusinessData {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
       //evento();
       usuario();
    }
    
    public static void evento() throws ParseException{
       BEvento bEvento = new BEvento();
       List<String> evento = new ArrayList<String>();
       evento.add("15 años");
       evento.add("2022-07-02");
       evento.add("20:00");
       evento.add("02:00");
       evento.add("Eventos Mary");
       evento.add("Cumpleaño #15 de Lenny Bravo");
       evento.add("acontecimiento social");
       
        try {
            bEvento.registrar(evento, "meridajose@uagrm.edu.bo");
        } catch (SQLException ex) {
            Logger.getLogger(BusinessData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void usuario(){
        BUsuario bUsuario = new BUsuario();
       List<String> usuario = new ArrayList<String>();
       usuario.add("Elena");
       usuario.add("elenaeguez@uagrm.edu.bo");
       usuario.add("123456");
       usuario.add("USER");
       
        try {
            bUsuario.registrar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(BusinessData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
