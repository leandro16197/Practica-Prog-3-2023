package Practico_3_2;


import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
  private ArrayList<Vertice> vertice;

	public GrafoDirigido() {
		this.vertice =new ArrayList<Vertice>();
	}

	@Override
	//O(n)
	public void agregarVertice(int verticeId) {
			if(this.contieneVertice(verticeId)==false) {
				this.vertice.add(new Vertice(verticeId));
			}
	}

	public ArrayList<Vertice> getVertice(){
		return new ArrayList<Vertice>(this.vertice);
	}
	@Override
	public void borrarVertice(int verticeId) {
		int pos = this.getPosVertice(verticeId);
		if(pos>=0){
			for(int i=0;i<this.vertice.size();i++){
				this.vertice.get(i).deleteArco(verticeId);
			}
			this.vertice.remove(pos);
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).addAdyasentes(verticeId2,etiqueta);
			}
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).deleteArco(verticeId2);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId()==verticeId){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0) {
			if (this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).contiene(verticeId2);
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		int pos=this.getPosVertice(verticeId1);
		if(pos>=0){
			if(this.contieneVertice(verticeId2)==true){
				return this.vertice.get(pos).getArco(verticeId2);
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertice.size() ;
	}

	@Override
	public int cantidadArcos() {
		int total=0;
		for(int i=0;i<this.vertice.size();i++){
			total=total+this.vertice.get(i).adyasentesSize();
		}
		return total;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> it=this.getIdVertice().iterator();
		return it;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>=0){
			Iterator<Integer>it=this.vertice.get(pos).getIdAdyasentes().iterator();
			return it;
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>>aux=new ArrayList<>();
		for(int i=0;i<this.vertice.size();i++){
			aux.addAll(this.vertice.get(i).getIdAdyasentes());
		}
		Iterator it=aux.iterator();
		while(it.hasNext()){
			it.next();
		}
		return it;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>=0){
			Iterator it=this.vertice.get(pos).getListaArco().iterator();
			while (it.hasNext()){
				it.next();
			}
			return it;
		}
		return null;
	}

	@Override
	public boolean tieneAdaysentes(int aux) {
		int pos=this.getPosVertice(aux);
		if(pos>=0){
			if(this.vertice.get(pos).getAdyasentes().size()>0){
				return true;
			}
		}
		return false;
	}

	private int getPosVertice(int verticeId){
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId()==verticeId){
				return i;
			}
		}
		return -1;
	}
	private ArrayList<Integer> getIdVertice(){
		ArrayList<Integer> aux=new ArrayList<Integer>();
		for(int i=0;i<this.vertice.size();i++){
			aux.add(this.vertice.get(i).getId());
		}
		return aux;
	}
}
