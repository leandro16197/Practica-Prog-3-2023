package Practico_3_2;

import java.util.*;


class ServicioCaminos {

        private Grafo<?> grafo;
        private int origen;
        private int destino;
        private int lim;
        private HashMap map;

        // Servicio caminos
        public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
            this.grafo = grafo;
            this.origen = origen;
            this.destino = destino;
            this.lim = lim;
            this.map=new HashMap();
        }
        public List<List<Integer>> caminos() {
            Iterator<Integer> it1=this.grafo.obtenerVertices();
            while(it1.hasNext()){
                this.map.put(it1.next(),"blanco");
            }

            List<Integer> lista=new ArrayList();
            List<List<Integer>> recorrido=new ArrayList();
            camino(this.origen,lista,recorrido);
            return recorrido;
        }

    private void camino(int i, List lista,List recorrido) {
            this.map.replace(i,"amarillo");
            if(lista.isEmpty()){
                lista.add(i);
            }
            if(lista.size()<this.lim){
                if(this.destino==i){
                recorrido.add(lista);
            }else{
                Iterator<Integer>it3=this.grafo.obtenerAdyacentes(i);
                while (it3.hasNext()){
                    int aux=it3.next();
                    if(this.grafo.tieneAdaysentes(aux)==true){
                        lista.add(aux);
                        if(this.map.get(aux).equals("blanco")){
                            camino(aux,lista,recorrido);

                        }

                        lista.remove(lista.indexOf(aux)x);
                    }
                }
            }
        }
        this.map.replace(i,"blanco");
    }
}



