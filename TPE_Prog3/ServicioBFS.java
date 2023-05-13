package Practico_3_2;

import Practico_3_2.Grafo;

import java.sql.SQLOutput;
import java.util.*;

class ServicioBFS {

    public HashMap map;
    public Grafo<?> grafo;

    public ServicioBFS(Grafo g){
        this.map=new HashMap();
        this.grafo=g;
    }
    public List<Integer> ServicioBFS() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        while (it.hasNext()) {
            this.map.put(it.next(), "no_visitado");
        }
        List<Integer> lista = new ArrayList<>();
        it = this.grafo.obtenerVertices();
        while (it.hasNext()) {
            Integer aux = it.next();
            if (this.map.get(aux).equals("no_visitado")) {
                lista.add(aux);
                bfs(aux,lista);
            }
        }
        return lista;
    }

    private void bfs(int aux,List lista) {
        Queue<Integer> cola = new LinkedList<>();
        this.map.replace(aux, "visitado");
        cola.offer(aux);
        while (!cola.isEmpty()) {
            Integer v = cola.poll();
            Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
            while (it.hasNext()) {
                int i = it.next();
                if (this.map.get(i).equals("no_visitado")) {
                    this.map.replace(i, "visitado");
                    lista.add(i);
                    cola.offer(i);
                }
            }
        }
    }
}
