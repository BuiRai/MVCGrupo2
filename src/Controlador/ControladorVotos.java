package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.AdminVotos;
import Modelo.Candidato;
import Vista.VentanaPrincipal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a09001005
 */
public class ControladorVotos extends Controlador{
    private String nombre=this.getClass().getName();
    VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(this);

    public ControladorVotos(AdminVotos modelo, int idEvento) {      
        super(modelo, idEvento);
    }


    public void realizarVotacion(String candidato) {
        ((AdminVotos)super.getModelo()).agregarVoto(candidato);
    }
    
    public void desplegarVentana(){
        ventanaPrincipal.rellenarCBoxCandidatos((ArrayList<Candidato>)modelo.getDatos());
        ventanaPrincipal.setVisible(true);
    }
    
        @Override
    public void actualizar(Object o) {
        super.actualizar(o);
        desplegarVentana();
    }
}
