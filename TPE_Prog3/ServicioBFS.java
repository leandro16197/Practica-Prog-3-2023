package Practico_3_2;


import java.util.*;

class ServicioBFS {

    private HashMap map;
    private Grafo<?> grafo;

    public ServicioBFS(Grafo g){
        this.map=new HashMap();
        this.grafo=g;
    }

    //la complejidad computacional va a ser o(2^n) siendo n la lista de vertices ya que recorre 2 veces
    //la primera para ponerlos como no visitados
    //la segunda llamando al metodo bfs

    public List<Integer> bfsForest(){
        Iterator<Integer> it = this.grafo.obtenerVertices();
        while (it.hasNext()) {
            this.map.put(it.next(), "no_visitado");
        }
        List<Integer> listaDescubrimiento = new ArrayList<>();
        it = this.grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer aux = it.next();
            if (this.map.get(aux).equals("no_visitado")) {
                bfsForest_Visit(aux,listaDescubrimiento);
            }
        }
        return listaDescubrimiento;

    }

    //la complejidad computacional va a ser o(2^n) siendo n la lista de vertices ya que recorre 2 veces
    //la primera recorriendo la cola por cada vertice no visitado
    //la segunda por cada adyasente y agregandolo a la lista recorrido

    private void bfsForest_Visit(Integer aux, List<Integer> lista) {
        List<Integer> recorrido=new ArrayList<>();
        this.map.replace(aux,"visitado");
        recorrido.add(aux);
        lista.add(aux);
        while(!recorrido.isEmpty()){
            Integer v=recorrido.remove(0);
            Iterator<Integer> it=this.grafo.obtenerAdyacentes(v);
            while(it.hasNext()){
                Integer i= it.next();
                if(this.map.get(i).equals("no_visitado")){
                    this.map.replace(i,"visitado");
                    recorrido.add(i);
                    lista.add(i);
                }
            }
        }
    }

}
