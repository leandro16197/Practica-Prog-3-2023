package Practico_3_2;

import java.util.Iterator;

public class Main<T>{
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);
        grafo.agregarArco(2,7, "2 a 7");
        grafo.agregarArco(7,1, "7 a 1");
        grafo.agregarArco(7,4, "7 a 4");
        grafo.agregarArco(1,3, "1 a 3");
        grafo.agregarArco(3,9, "3 a 9");
        grafo.agregarArco(3,4, "3 a 4");
        grafo.agregarArco(4,6, "4 a 6");
        grafo.agregarArco(4,5, "4 a 5");
        grafo.agregarArco(5,8, "5 a 8");
        grafo.agregarArco(6,8, "6 a 8");

        ServicioDFS dfs=new ServicioDFS(grafo);
        ServicioBFS bfs=new ServicioBFS(grafo);
        System.out.println("Orden posible dfs : "+ dfs.ServicioDFS());
        System.out.println("Orden posible bfs : "+ bfs.ServicioBFS());
        ServicioCaminos caminos=new ServicioCaminos(grafo,7,4,50);
        System.out.println(caminos.caminos());

        /*int cantVertices = grafo.cantidadVertices();
        System.out.println("Hay " + cantVertices + " Vertices en este grafo");

        if(grafo.contieneVertice(5)){
            System.out.println("El vertice 5 existe en este grafo");
        }

        grafo.agregarArco(2,7, "2 a 7");
        grafo.agregarArco(7,1, "7 a 1");
        grafo.agregarArco(1,3, "1 a 3");
        grafo.agregarArco(3,9, "3 a 9");
        grafo.agregarArco(3,4, "3 a 4");
        grafo.agregarArco(4,6, "4 a 6");
        grafo.agregarArco(4,5, "4 a 5");
        grafo.agregarArco(5,8, "5 a 8");
        grafo.agregarArco(6,8, "6 a 8");
        grafo.agregarArco(10,8, "10 a 8");
        grafo.agregarArco(8,10, "8 a 10");
        grafo.borrarArco(6,8);
        int cantArcos = grafo.cantidadArcos();
        System.out.println("Hay " + cantArcos + " Arcos en este grafo");

        if(grafo.existeArco(3,4)){
            System.out.println("El arco entre 3 y 4 existe en este grafo");
        }

        int objetivo = 4;
        Iterator<Integer> it = grafo.obtenerAdyacentes(objetivo);

        while (it.hasNext()){
            int v = it.next();
            System.out.println(v + " es adyacente a " + objetivo);

        }
    */
    }
}
