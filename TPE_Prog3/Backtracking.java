package Practico_3_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Backtracking<T> {

    private ArrayList<Arco> tunelMejor;

    public Backtracking() {
        this.tunelMejor = new ArrayList<Arco>();
        this.tunelMejor.add(new Arco(1, 4, Integer.MAX_VALUE));
    }
    public void backTracking(Grafo g, ArrayList<Arco> tunel) {
       if(solucion(g,tunel)){
           if (sumaTunel(tunel) < sumaTunel(this.tunelMejor)) {
               this.tunelMejor = new ArrayList<>(tunel);
           }
        }else {
            if(!g.getArco().isEmpty()){
                Arco<T> aux= (Arco<T>) g.getArco().get(0);
                g.borrarArco(aux.getVerticeOrigen(),aux.getVerticeDestino());
                if(!tunel.contains(aux)){
                    tunel.add(aux);
                    backTracking(g,tunel);
                    tunel.remove(aux);
                    backTracking(g,tunel);
                    g.agregarArco(aux.getVerticeOrigen(), aux.getVerticeDestino(),aux.getEtiqueta());
                }
            }
        }
    }

    public void getMejorTunel(){
        for(int i=0;i<this.tunelMejor.size();i++){
            System.out.print(this.tunelMejor.get(i).getVerticeOrigen()+"->"+this.tunelMejor.get(i).getVerticeDestino());
        }
    }

<<<<<<< HEAD
    private boolean solucion(Grafo g, ArrayList<Arco> tunel) {
        ArrayList<Vertice<T>> verticesTunel = this.obtenerVertice(tunel);

        // Verificar si la lista está vacía
        if (verticesTunel.isEmpty()) {
            return false;
        }

        // Utilizar el primer vértice como vértice inicial para la búsqueda en profundidad
        Vertice<T> verticeInicial = verticesTunel.get(0);

=======
   private boolean solucion(Grafo g, ArrayList<Arco> tunel) {
        ArrayList<Vertice<T>> verticesTunel = this.obtenerVertice(tunel);

        // Verificar si la lista está vacía
        if (verticesTunel.isEmpty()) {
            return false;
        }

        // Utilizar el primer vértice como vértice inicial para la búsqueda en profundidad
        Vertice<T> verticeInicial = verticesTunel.get(0);

>>>>>>> master
        // Realizar la búsqueda en profundidad desde el vértice inicial
        HashSet<Vertice<T>> visitados = new HashSet<>();
        dfs(g, verticeInicial, visitados);

        // Verificar si todos los vértices en la lista tunel fueron visitados
        for (Vertice<T> vertice : verticesTunel) {
            if (!visitados.contains(vertice)) {
                return false;
            }
        }

        return true;
<<<<<<< HEAD
    }

    private void dfs(Grafo g, Vertice<T> vertice, HashSet<Vertice<T>> visitados) {
        visitados.add(vertice);
        // Obtener los vértices adyacentes al vértice actual
        ArrayList<Vertice<T>> adyacentes = g.obtenerAdyacentes(vertice);

        // Recorrer los vértices adyacentes y realizar la búsqueda en profundidad recursivamente
        for (Vertice<T> adyacente : adyacentes) {
            if (!visitados.contains(adyacente)) {
                dfs(g, adyacente, visitados);
            }
        }
=======
>>>>>>> master
    }

    private void dfs(Grafo g, Vertice<T> vertice, HashSet<Vertice<T>> visitados) {
        visitados.add(vertice);
        // Obtener los vértices adyacentes al vértice actual
        ArrayList<Vertice<T>> adyacentes = g.obtenerAdyacentes(vertice);

        // Recorrer los vértices adyacentes y realizar la búsqueda en profundidad recursivamente
        for (Vertice<T> adyacente : adyacentes) {
            if (!visitados.contains(adyacente)) {
                dfs(g, adyacente, visitados);
            }
        }
    }


    private ArrayList<Vertice<T>> obtenerVertice(ArrayList<Arco> l) {
        ArrayList<Vertice<T>> aux = new ArrayList<>();
        HashSet<Integer> setVertices = new HashSet<>();
        for (Arco arco : l) {
            if (!setVertices.contains(arco.getVerticeOrigen())) {
                aux.add(new Vertice<>(arco.getVerticeOrigen()));
                setVertices.add(arco.getVerticeOrigen());
            }
            if (!setVertices.contains(arco.getVerticeDestino())) {
                aux.add(new Vertice<>(arco.getVerticeDestino()));
                setVertices.add(arco.getVerticeDestino());
            }
        }
        return aux;
    }
    private int sumaTunel(ArrayList<Arco> a) {
        int total = 0;
        for(int i=0;i<a.size();i++){
            total+=(int)a.get(i).getEtiqueta();
        }
        return total;
    }
    public int getTamMejorTunel(){
        return this.tunelMejor.size();
    }

}
