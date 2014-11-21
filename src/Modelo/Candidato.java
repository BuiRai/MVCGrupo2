/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author David Cocom
 */
public class Candidato {

    private String nombre;
    private int numVotos;


    public Candidato(String nombre) {
        this.nombre = nombre;
        this.numVotos = 0;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void agregarVoto() {
        ++numVotos;
    }

}