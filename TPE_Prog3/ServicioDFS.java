package Practico_3_2;


import java.util.*;

public class ServicioDFS {
    public HashMap map;
    public Grafo<?> grafo;

    public ServicioDFS(Grafo<?> g){
        this.map=new HashMap();
        this.grafo=g;
    }

    public List<Integer> ServicioDFS(){
        Iterator<Integer> i= this.grafo.obtenerVertices();  // O(V) Con V la cantidad de vertices
        ArrayList<Integer> lista=new ArrayList();  // O(1)
        while(i.hasNext()){  // O(V) Con V la cantidad de vertices
            this.map.put(i.next(),"blanco");  // O(1)
        }
        Iterator<Integer> it2= this.grafo.obtenerVertices();  // O(V) Con V la cantidad de vertices
        while (it2.hasNext()){  // O(V)
            int aux=it2.next();  // O(1)
            if(map.get(aux).equals("blanco")){  // O(1)
                lista.add(aux);  // O(1)
                dfs_visit(aux,lista);  // O(V + E) Con V la cantidad de vertices y E la cantidad de arcos
            }
        }
        return lista;  // O(1)
    }

    private void dfs_visit(int v, ArrayList lista) {
        this.map.replace(v,"amarillo");  // O(1)
        Iterator<Integer>it3=this.grafo.obtenerAdyacentes(v);  // O(E) Con E la cantidad de arcos
        while (it3.hasNext()){  // O(E) Con E la cantidad de arcos
            int aux=it3.next();  // O(1)
            lista.add(aux);  // O(1)
            if(this.map.get(aux).equals("blanco")){  // O(1)
                dfs_visit(aux,lista);  // O(V + E) Con V la cantidad de vertices y E la cantidad de arcos
            }
        }
        this.map.replace(v,"negro");  // O(1)
    }

    public List<Integer> dfsForest() {
        List<Integer> forest = new ArrayList<>();  // O(1)
        List<Integer> vertices = new ArrayList<>((Collection) this.grafo.obtenerVertices());  // O(V) Con V la cantidad de vertices
        while (!vertices.isEmpty()) {  // O(V) Con V la cantidad de vertices
            List<Integer> component = ServicioDFS();  // O(V + E) Con V la cantidad de vertices y E la cantidad de arcos
            forest.addAll(component);  // O(V) Con V la cantidad de vertices
            vertices.removeAll(component);  // O(V^2) Con V la cantidad de vertices
        }
        return forest;  // O(1)
    }

}