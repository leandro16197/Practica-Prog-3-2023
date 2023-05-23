package Practico_3_2;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
    private int id;
    private ArrayList<Arco> adyasentes;

    public Vertice(int id) {
        this.id = id;
       this.adyasentes=new ArrayList<Arco>();
    }
    /**
     * Complejidad: O(n) n es el tamaño maximo de la lista  de adyasentes
     * recorre la lista de adyasentes donde verifica que no exista un arco cuyo id sea
     * el que se le pasa por parametros para poder crear un nuevo arco
     */
    public void addAdyasentes(int id2,T etiqueta){
        if(this.contiene(id2)==false){
            this.adyasentes.add(new Arco(this.id,id2,etiqueta));
        }
    }
    /**
     * Complejidad: O(n) n es el tamaño maximo de la lista  de adyasentes
     * recorre la lista de adyasentes donde verifica que exista o no un arco cuyo id sea el que se pasa
     * por parametros
     */
    public boolean contiene(int destino){
        for(int i=0;i<this.adyasentes.size();i++){
            if(this.adyasentes.get(i).getVerticeDestino()==destino){
                return true;
            }
        }
        return false;
    }
    /**
     * Complejidad: O(n) n es el tamaño maximo de la lista  de adyasentes
     * recorre la lista de adyasentes para buscar un arco con cuyo id
     * sea el que se le pasa para luego retornarlo
     */
    public Arco<T> getArco(int id){
        for(int i=0;i<this.adyasentesSize();i++){
            if(this.adyasentes.get(i).getVerticeDestino()==id){
                return this.adyasentes.get(i);
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Complejidad: O(n) n es el tamaño maximo de la lista  de arcos
     * recorre la lista de arcos para luego guardarla en otra lista
     * y retornar una lista con los id de los vertices destino
     */
    public ArrayList<Integer> getIdAdyasentes(){
        ArrayList<Integer> aux=new ArrayList<Integer>();
        for(int i=0;i<this.adyasentes.size();i++){
            aux.add(this.adyasentes.get(i).getVerticeDestino());
        }
        return aux;
    }
    public int adyasentesSize(){
        return this.adyasentes.size();
    }
    public List getAdyasentes() {
        return adyasentes;
    }
    /**
     * Complejidad: O(1) ya que su complejidad va a ser la misma sin importar el tamaño
     * crea y retorna una copia de la lista adyasentes
     */
    public ArrayList<Arco> getListaArco(){
        return new ArrayList<>(this.adyasentes);
    }
    /**
     * Complejidad: O(n*2) n es el tamaño de la lista
     * recorre la lista usando contiene() para verificar que exista un arco cuyo id sea el mismo
     * pasado por parametro y luego la recorre para encontrar la posicion y poder eliminarla
     * de la lista de adyasentes
     */
    public boolean deleteArco(int id){
        if(this.contiene(id)==true){
            for(int i=0;i<this.adyasentes.size();i++){
                if(this.adyasentes.get(i).getVerticeDestino()==id){
                    return this.adyasentes.remove(this.adyasentes.get(i));
                }
            }
        }
        return false;
    }

}
