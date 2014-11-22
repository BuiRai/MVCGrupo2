/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author BuiRai
 */
public class AsignadorDeId {
    public static AsignadorDeId INSTANCE = new AsignadorDeId();
    private int currentId;

    public AsignadorDeId() {
        currentId = 0;
    }
    
    public static AsignadorDeId getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new AsignadorDeId();
        }
        return INSTANCE;
    }
    
    public int generarId(){
        int idGenerada = currentId;
        currentId++;
        return idGenerada;
    }
    
}
