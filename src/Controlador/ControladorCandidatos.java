package Controlador;

import Modelo.AdminVotos;
import Modelo.Modelo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vaio
 */
public class ControladorCandidatos extends Controlador{
    
    private String nombre=this.getClass().getName();

    public ControladorCandidatos(Modelo modelo, int idEvento) {
        super(modelo, idEvento);
    }

    public void agregarCandidato(String candidato){
        ((AdminVotos)super.getModelo()).agregarCandidatos(candidato);
    }
    
    
    public void eliminarCandidato(String candidato){
        ((AdminVotos)super.getModelo()).eliminarCandidatos(candidato, this.nombre);
    }
    
}
