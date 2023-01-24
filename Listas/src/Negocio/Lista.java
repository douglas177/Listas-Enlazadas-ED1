/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Estudiante
 */
public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        L = null;
        cant = 0;
    }

    /*Toda Archivo de texto al ejecutarse se va a una estructura de datos(Listas ,Pilas ,Colas)*/
    public boolean Vacia() {
        return L == null;
    }

    public void Insertar(int Elemento) {
        if (Vacia()) {
            Nodo P = new Nodo();
            P.setData(Elemento);
            L = P;

        } else {
            Nodo Anterior = null;
            Nodo Aux = L;
            while ((Aux != null) && (Aux.getData() <= Elemento)) {
                Anterior = Aux;
                Aux = Aux.getEnlace();
            }
            if (Anterior == null) {
                Nodo P = new Nodo();
                P.setData(Elemento);
                P.setEnlace(L);
                L = P;

            } else {
                if (Anterior.getData() != Elemento) {
                    Nodo P = new Nodo();
                    P.setData(Elemento);
                    Anterior.setEnlace(P);
                    P.setEnlace(Aux);

                }
            }
        }
        cant++;
    }

    public void Eliminar(int Elemento) {
        if (!Vacia()) {
            Nodo Aux = L;
            Nodo Anterior = null;
            while ((Aux != null) && (Aux.getData() != Elemento)) {
                Anterior = Aux;
                Aux = Aux.getEnlace();
            }
            if (Aux != null) {
                if (Anterior == null) {
                    L = L.getEnlace();
                } else {
                    Anterior.setEnlace(Aux.getEnlace());
                }
                cant--;
            }
        }
    }

    public int GetDato(int pos) {
        Nodo Aux = L;
        for (int i = 1; i < pos; i++) {
            Aux = Aux.getEnlace();
        }
        return Aux.getData();
    }

    public boolean Existe(int Elemento) {
        Nodo Aux = L;
        while ((Aux != null) && (Aux.getData() != Elemento)) {
            Aux = Aux.getEnlace();
        }
        return Aux != null;
    }

    public int GetPosicion(int Elemento) {
        Nodo Aux = L;
        int cant = 0;
        while ((Aux != null) && (Aux.getData() != Elemento)) {
            Aux = Aux.getEnlace();
            cant++;
        }
        if (Aux != null) {
            return cant + 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        String S = "L => [ ";
        Nodo Aux = L;
        while (Aux != null) {
            S = S + Aux.getData() + " , ";
            Aux = Aux.getEnlace();
        }
        S = S.substring(0, S.length() - 2);
        return S + "]";

    }

   
}
