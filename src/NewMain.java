/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controlador.*;
import Modelo.*;
import Vista.*;

/**
 *
 * @author a09001005
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //AdminVotos admin=new AdminVotos();
        AdminVotos admin= new AdminVotos();
        //admin.inicializarCandidatos();
        ControladorVotos entrada=new ControladorVotos(admin, 0);
        Barras b=new Barras(admin,0);
        Pastel p=new Pastel(admin,0);
        Numeros v=new Numeros(admin,0);
        
        entrada.desplegarVentana();

    }
    
}
