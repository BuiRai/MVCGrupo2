package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a09001005
 */
import java.util.ArrayList;


public class Modelo {

    //Este atributo privado mantiene el vector con los observadores
    protected ArrayList<Evento> eventos;
    protected Object datos;

    //El constructor crea el vector con la asociacion Observable-Observador
    public Modelo() {
        eventos = new ArrayList();
    }

    public void registrarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento()==idEvento) {
                evento.agregarMiembro( observer);
                return;
            }
        }
    }

    public void eliminarObservador(Observer observer, int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento()==idEvento) {
                evento.eliminarMiembro(observer);
                return;
            }
        }
    }

    public void agregarEvento(Evento evento) {
        for (Evento evt : this.eventos) {
            if (evt.getIdEvento() == evento.getIdEvento()) {
                break;
            } else {
                eventos.add(evento);
            }
        }
    }

    public void notificarObservadoresEvento(int idEvento) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == idEvento) {
                for (Observer observer : evento.getMiembros()) {
                    observer.actualizar(getDatos());
                }
                break;
            }
        }
    }

    /**
     * @return the datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }

}
