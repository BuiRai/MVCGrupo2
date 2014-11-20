package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;


/**
 *
 * @author a09001005
 */
public class AdminVotos extends Modelo {

    static AdminVotos adminVtos;
    private ArrayList<Candidato> cands;
    private int contador = 0;
    private CacheCandidatos cache;

    
    public AdminVotos() {
        this.cands = new ArrayList();
        cache = new CacheCandidatos();
        initCand();
        initEventos();
        super.datos = cands;
    }

    public static AdminVotos getInstance() {
        if (adminVtos == null) {
            adminVtos = new AdminVotos();
        }
        return adminVtos;
    }

    public void initCand() {
        Candidato A = new Candidato("A");
        cands.add(A);
        Candidato B = new Candidato("B");
        cands.add(B);
        Candidato C = new Candidato("C");
        cands.add(C);
    }

    private void initEventos() {
        for (int i = 0; i < 3; i++) {
            eventos.add(new Evento(i));
        }
    }


    public void agregarCandidatos(ArrayList<Candidato> candidatos) {
        super.setDatos(candidatos);
        notificarObservadoresEvento(0);
    }
    
    //Retorna un candidato de la cache
    public Candidato getCandidatoEnCache(String nombre){
        return cache.getCandidato(nombre);
    }
    
    //Agrega un candidato a la cache
    public void agregarCandidatoEnCache(Candidato candidato){
        cache.agregarCandidato(candidato);
    }
    
    //Verifica si el candidato existe o no en la cache
    public boolean existenciaDeCandidato(String nombre){
        return cache.existenciaDeCandidato(nombre);
    }

    /**
     * Aqui se deberia de buscar al candidato en el cache 
     * @param nombre nombre del candidato
     */
    public void agregarVoto(String nombre) {
        if (existenciaDeCandidato(nombre)) {
            Candidato cndt = getCandidatoEnCache(nombre);
            cndt.agregarVoto();
            System.out.println("LOCALIZACION: Se localizo en la cache, pues ya se habia votado antes por el");
        }else{
            for (Candidato cand : (ArrayList<Candidato>) getDatos()) {
                if (cand.getNombre().equals(nombre)) {
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
            }
        }
        notificarObservadoresEvento(0);
    }


}
