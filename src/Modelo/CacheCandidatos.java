/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

/**
 *
 * @author BuiRai
 */
public class CacheCandidatos {
    private JCS jcsCache;
    
    public CacheCandidatos(){
        try {
            // Se carga el cache usando el archivo de configuracion
            jcsCache = JCS.getInstance("CandidateInformation");
        } catch (CacheException ex) {
            Logger.getLogger(CacheCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarCandidato(Candidato candidato){
        try {
            jcsCache.put(candidato.getNombre(), candidato);
        } catch (CacheException ex) {
            Logger.getLogger(CacheCandidatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Candidato getCandidato(String nombre){
        return (Candidato)jcsCache.get(nombre);
    }
    
    public boolean existenciaDeCandidato(String nombre){
        Candidato candidato;
        candidato = getCandidato(nombre);
        return candidato != null;
    }
    
}
