package Practico_3_2;

import Practico_3_2.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    public HashMap map;
    public Grafo<?> grafo;

    public ServicioDFS(Grafo<?> g){
        this.map=new HashMap();
        this.grafo=g;
    }

    public List<Integer> ServicioDFS(){
        Iterator<Integer> i= this.grafo.obtenerVertices();
        ArrayList<Integer> lista=new ArrayList();
        while(i.hasNext()){
            this.map.put(i.next(),"blanco");
        }
        Iterator<Integer> it2= this.grafo.obtenerVertices();
        while (it2.hasNext()){
            int aux=it2.next();
            if(map.get(aux).equals("blanco")){
                lista.add(aux);
                dfs_visit(aux,lista);
            }
        }
        return lista;
    }
    /**
     * Complejidad: O(V+A)donde V=Vertice y A=Adyasentes
     * ya que recorre todos los vertices(V) y a su ves por cada
     * vertice recorre sus Adyasentes(A)
     */
    private void dfs_visit(int v, ArrayList lista) {
        this.map.replace(v,"amarillo");
        Iterator<Integer>it3=this.grafo.obtenerAdyacentes(v);
        while (it3.hasNext()){
            int aux=it3.next();
            if(this.map.get(aux).equals("blanco")){
                lista.add(aux);
                dfs_visit(aux,lista);
            }
        }
        this.map.replace(v,"negro");
    }
}
