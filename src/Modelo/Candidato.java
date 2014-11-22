/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import ArquiSoftware.Cacheable;
import java.io.Serializable;

/**
 *
 * @author David Cocom
 */
public class Candidato implements Serializable , Cacheable{

    private String nombre;
    private int numVotos;
    private int id;

    public Candidato(String nombre) {
        this.nombre = nombre;
        id = AsignadorDeId.getInstance().generarId();
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

    @Override
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

}