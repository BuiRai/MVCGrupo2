package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ArquiSoftware.CacheMVC;
import ArquiSoftware.ObjetoDesconocidoException;
import ArquiSoftware.ObjetoDuplicadoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author a09001005
 */
public class AdminVotos extends Modelo {

    static AdminVotos adminVtos;
    private ArrayList<Candidato> cands;
    private int contador = 0;
    private CacheMVC cache;

    public AdminVotos() {
        this.cands = new ArrayList();
        cache = new CacheMVC();
        inicializarCandidatos();
        inicializarEventos();
        super.datos = cands;
    }

    public static AdminVotos getInstance() {
        if (adminVtos == null) {
            adminVtos = new AdminVotos();
        }
        return adminVtos;
    }
    
    public int getContador(){
        return contador;
    }

    public void inicializarCandidatos() {
        Candidato A = new Candidato("A");
        cands.add(A);
        Candidato B = new Candidato("B");
        cands.add(B);
        Candidato C = new Candidato("C");
        cands.add(C);
    }

    private void inicializarEventos() {
        int numeroDeEventos=3;
        for (int i = 0; i < numeroDeEventos; i++) {
            eventos.add(new Evento(i));
        }
    }
    
    public void agregarCandidatos(ArrayList<Candidato> candidatos) {
        super.setDatos(candidatos);
        notificarObservadoresEvento(0);
    }

    //Retorna un candidato de la cache
    public Object getCandidatoEnCache(int id){
        Object objeto = null;
        try {
            objeto = cache.obtenerObjeto(id);
        } catch (ObjetoDesconocidoException ex) {
            Logger.getLogger(AdminVotos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objeto;
    }
    
    //Agrega un candidato a la cache
    public void agregarCandidatoEnCache(Candidato candidato){
        try {
            cache.agregarObjeto(candidato);
        } catch (ObjetoDuplicadoException ex) {
            Logger.getLogger(AdminVotos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Verifica si el candidato existe o no en la cache
    public boolean existenciaDeCandidato(int id){
        return cache.existenciaDeObjeto(id);
    }

    /**
     * Aqui se deberia de buscar al candidato en el cache 
     * @param id ID del candidato
     */
    public void agregarVoto(int id) {
        if (existenciaDeCandidato(id)) {
            Candidato cndt = (Candidato)getCandidatoEnCache(id);
            cndt.agregarVoto();
            System.out.println("LOCALIZACION: Se localizo en la cache, pues ya se habia votado antes por el");
        }else{
            for (Candidato cand : (ArrayList<Candidato>) getDatos()) {
                if (cand.getId() == id) {
                    cand.agregarVoto();
                    System.out.println("LOCALIZACION: Se localizo en el ArrayList, pues es primera vez que se vota por el");
                    agregarCandidatoEnCache(cand);
                }
            }
        }
        
        notificarObservadoresEvento(0);
    }

    public void agregarCandidatos(String nombre) {
        Candidato temp = new Candidato(nombre);
        ((ArrayList<Candidato>) super.getDatos()).add(temp);
        notificarObservadoresEvento(0);
    }

    public void eliminarCandidatos(String nombre, String peticion) {
        for (Candidato candidato : ((ArrayList<Candidato>)getDatos())) {
            if (candidato.getNombre().equals(nombre)) {
                ((ArrayList<Candidato>) getDatos()).remove(candidato);
                break;
            }
        }
        notificarObservadoresEvento(0);
    }
    
//    public static void main(String[] args) {
//        Candidato c1 = new Candidato("F");
//        Candidato c2 = new Candidato("L");
//        c2.setId(6);
//        Candidato c3 = new Candidato("O");
//        c3.setId(6);
//        AdminVotos.getInstance().agregarCandidatoEnCache(c1);
//        AdminVotos.getInstance().agregarCandidatoEnCache(c2);
//        AdminVotos.getInstance().agregarCandidatoEnCache(c3);
//        AdminVotos.getInstance().getCandidatoEnCache(90);
//    }

}
