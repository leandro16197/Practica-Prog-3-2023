package Practico_3_2;


import javafx.scene.shape.Arc;

import java.util.ArrayList;


public class Greedy <T>{
    private ArrayList<Arco<T>>greedyMejorTunel;
    private int metrica;
    public Greedy(){
        this.greedyMejorTunel=new ArrayList<Arco<T>>();
        this.metrica=0;

    }

    public void Greedy(Grafo g){
        this.metrica++;
        ArrayList<Arco<T>> posibleSolucion=new ArrayList<Arco<T>>();
        ArrayList<Arco<T>> arcos=new ArrayList<Arco<T>>(g.getArco());
        Arco<T>aux=obtenerMenor(arcos);
        arcos.remove(aux);
        posibleSolucion.add(aux);
        while(!solucion(g,posibleSolucion) && !arcos.isEmpty()){
            this.metrica++;
            aux=obtenerMenor(arcos);
            arcos.remove(aux);
            if(factible(aux,posibleSolucion)==true) {
                posibleSolucion.add(aux);
            }

        }
        this.greedyMejorTunel=posibleSolucion;
    }

    private Arco<T> obtenerMenor(ArrayList<Arco<T>> arcos) {
        Arco<T>aux=new Arco(1, 4, Integer.MAX_VALUE);
        for(int i=0;i<arcos.size();i++){
            if(Integer.parseInt(arcos.get(i).getEtiqueta().toString())
                    <Integer.parseInt(aux.getEtiqueta().toString())){
                aux=arcos.get(i);
            }
        }
        return aux;
    }

    private boolean factible(Arco<T> aux, ArrayList<Arco<T>> posibleSolucion) {
        Arco<T>arcoEspejo=new Arco<>(aux.getVerticeDestino(), aux.getVerticeOrigen(), aux.getEtiqueta());
        boolean factible=true;
        for(int i=0;i<posibleSolucion.size();i++){
            if(arcoEspejo.getVerticeOrigen()==posibleSolucion.get(i).getVerticeOrigen() &&
               arcoEspejo.getVerticeDestino()== posibleSolucion.get(i).getVerticeDestino() ){
                factible=false;
            }
        }
        return factible;
    }


    public void informeGreedy(){
        System.out.println("Greedy");
        for(int i=0;i<this.greedyMejorTunel.size();i++){
            System.out.print("E"+this.greedyMejorTunel.get(i).getVerticeOrigen()+"->"+"E"+this.greedyMejorTunel.get(i).getVerticeDestino()+" ");
        }
        System.out.println("  ");
        int valorTunel=this.sumaTunel(this.greedyMejorTunel);
        System.out.println(valorTunel+" Kms");
        System.out.println(this.getMetrica()+" metrica ");

    }
    public int getMetrica(){
        return this.metrica;
    }
    private Integer sumaTunel(ArrayList<Arco<T>> a) {
        int total = 0;
        for(int i=0;i<a.size();i++){
            total+=(Integer) a.get(i).getEtiqueta();
        }
        return total;
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

}
