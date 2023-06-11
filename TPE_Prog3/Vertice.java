package Practico_3_2;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
    private int id;
    private ArrayList<Arco> adyasentes=new ArrayList<Arco>();

    public Vertice(int id) {
        this.id = id;
    }

    public void addAdyasentes(int id2,T etiqueta){
        if(this.contiene(id2)==false){
            this.adyasentes.add(new Arco(this.id,id2,etiqueta));
        }
    }

    public boolean contiene(int destino){
        for(int i=0;i<this.adyasentes.size();i++){
            if(this.adyasentes.get(i).getVerticeDestino()==destino){
                return true;
            }
        }
        return false;
    }
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
    public ArrayList<Arco> getListaArco(){
        return new ArrayList<>(this.adyasentes);
    }
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
    @Override
    public boolean equals(Object o) {
        Vertice a = (Vertice) o;
        if (this.getId() == a.getId()) {
            return true;
        }
        return false;
    }

}
