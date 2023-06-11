package Practico_3_2;

import java.util.ArrayList;
import java.util.HashSet;

public class Backtracking<T> {

    private ArrayList<Arco> tunelMejor;

    public Backtracking() {
        this.tunelMejor = new ArrayList<Arco>();
        this.tunelMejor.add(new Arco(1, 2, Integer.MAX_VALUE));
    }
    public void backTracking(Grafo g, ArrayList<Arco> tunel) {
       if(solucion(g,tunel)){
           if (sumaTunel(tunel) < sumaTunel(this.tunelMejor)) {
               this.tunelMejor = new ArrayList<>(tunel);;
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

    public boolean solucion(Grafo g,ArrayList<Arco> a){
        boolean verificar=true;
        


        return verificar;
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
