package Practico_3_2;

import java.util.ArrayList;
import java.util.HashSet;

public class Backtracking<T> {

    private ArrayList<Arco<T>> tunelMejor;
    private int metrica;
    private int mejorMetrica;

    public Backtracking() {
        this.tunelMejor = new ArrayList<>();
        this.tunelMejor.add(new Arco(1, 4, Integer.MAX_VALUE));
        this.metrica=0;
        this.mejorMetrica=0;
    }
    public void backTracking(Grafo g, ArrayList<Arco<T>> tunel,int met) {
        this.metrica++;
        if(solucion(g, tunel)){
            if (sumaTunel(tunel) < sumaTunel(this.tunelMejor)) {
                this.tunelMejor = new ArrayList<>(tunel);
                this.mejorMetrica=this.metrica;
            }
        }else {
            if(!g.getArco().isEmpty()){
                Arco<T> aux= (Arco<T>) g.getArco().get(0);
                g.borrarArco(aux.getVerticeOrigen(),aux.getVerticeDestino());
                if(!tunel.contains(aux)){
                    tunel.add(aux);
                    backTracking(g,tunel,this.metrica+1);
                    tunel.remove(aux);
                    backTracking(g,tunel,this.metrica+1);
                    g.agregarArco(aux.getVerticeOrigen(), aux.getVerticeDestino(),aux.getEtiqueta());
                }
            }
        }
    }

    public void informeBacktracking(){
        System.out.println("BackTracking");
        for(int i=0;i<this.tunelMejor.size();i++){
            System.out.print("E"+this.tunelMejor.get(i).getVerticeOrigen()+"->"+"E"+this.tunelMejor.get(i).getVerticeDestino()+" ");
        }
        System.out.println("  ");
        int valorTunel=this.sumaTunel(this.tunelMejor);
        System.out.println(valorTunel+" Kms");
        System.out.println(this.getMejorMetrica()+" metrica ");
    }

    public int getMejorMetrica() {
        return mejorMetrica;
    }

    private int getMetrica(){
        return this.metrica;
    }
    private boolean solucion( Grafo<T> g, ArrayList<Arco<T>> tunel) {
        UnionFind uf=new UnionFind(g.cantidadVertices());
        for(int i=0;i<tunel.size();i++){
            int vertice1 = tunel.get(i).getVerticeOrigen();
            int vertice2 = tunel.get(i).getVerticeDestino();
            int root1=uf.find(vertice1-1);
            int root2=uf.find(vertice2-1);
            uf.union(root1,root2);
        }
        int root = uf.find(0);
        boolean flag =true;
        for (int i = 0; i < g.cantidadVertices(); i++) {
            if (uf.find(i) != root){
                flag = false;
                break;
            }
        }
        return flag;
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
    private Integer sumaTunel(ArrayList<Arco<T>> a) {
        int total = 0;
        for(int i=0;i<a.size();i++){
            total+=(Integer) a.get(i).getEtiqueta();
        }
        return total;
    }
    public int getTamMejorTunel(){
        return this.tunelMejor.size();
    }

}