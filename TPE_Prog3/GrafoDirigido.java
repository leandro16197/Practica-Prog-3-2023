package Practico_3_2;


import java.util.ArrayList;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
  private ArrayList<Vertice> vertice;

	public GrafoDirigido() {
		this.vertice =new ArrayList<Vertice>();
	}

	@Override
	/**
	 * Complejidad: O(n) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista de vertices donde verifica que no exista un vertice cuyo id sea
	 * el que se le pasa por parametros para poder crear un nuevo vertice
	 */
	public void agregarVertice(int verticeId) {
			if(this.contieneVertice(verticeId)==false) {
				this.vertice.add(new Vertice(verticeId));
			}
	}

	public ArrayList<Vertice> getVertice(){
		return new ArrayList<Vertice>(this.vertice);
	}
	@Override
	/**
	 * Complejidad: O(n*2) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista buscando la posicion del vertice para verificar que exista
	 * luego recorre la lista de vertices para poder eliminar los arcos que tengan el
	 * vertice pasado por parametro como destino y luego lo elimina de la lista vertice
	 */
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
	/**
	 * Complejidad: O(n*2) n es el tamaño maximo de la lista  de vertices
	 * utilisa el metodo getPosVertice recorre la lista retorna >0 si existe
	 * utilisa el metodo contieneVertice que retorna true si existe el segundo vertice
	 * luego en base a la pos obtenida llama al metodo addAyasentes donde crea el arco
	 */
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).addAdyasentes(verticeId2,etiqueta);
			}
		}
	}

	@Override
	/**
	 * Complejidad: O(n*2) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista de vertices donde verifica que no exista un vertice cuyo id sea
	 * el que se le pasa por parametros para poder crear un nuevo vertice
	 */
	public void borrarArco(int verticeId1, int verticeId2) {
		int pos = this.getPosVertice(verticeId1);
		if(pos>=0){
			if (this.contieneVertice(verticeId2) == true) {
				this.vertice.get(pos).deleteArco(verticeId2);
			}
		}
	}

	@Override
	/**
	 * Complejidad: O(n) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista de vertices donde verifica que exista un vertice cuyo id==VerticeId
	 */
	public boolean contieneVertice(int verticeId) {
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId()==verticeId){
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * Complejidad: O(n*2) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista de vertices donde verifica que exista un vertice cuyo id==VerticeId1 retornando la posicion
	 * luego en contieneVertice() verifica que exista un vertice con id==verticeId2
	 */
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
/**
 * Complejidad: O(n*2) n es el tamaño maximo de la lista  de vertices
 * recorre la lista de vertices donde verifica que exista un vertice cuyo id==VerticeId1 retornando la posicion
 * luego en contieneVertice() verifica que exista un vertice con id==verticeId2
 * retorna el arco que cumpla las 2 condiciones
 */
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
	/**
	 * Complejidad: O(n) n es el tamaño maximo de la lista  de vertices
	 * recorre la lista y va sumando la cantidad de arcos que existen
	 * luego retorna el total
	 */
	public int cantidadArcos() {
		int total=0;
		for(int i=0;i<this.vertice.size();i++){
			total=total+this.vertice.get(i).adyasentesSize();
		}
		return total;
	}

	@Override
	/**
	 * Complejidad: O(1) ya que su complejidad va a ser la misma sin importar el tamaño
	 * crea y retorna un iterator
	 */
	public Iterator<Integer> obtenerVertices() {
		Iterator<Integer> it=this.getIdVertice().iterator();
		return it;
	}

	@Override
	/**
	 * Complejidad: O(1) ya que su complejidad va a ser la misma sin importar el tamaño
	 * crea y retorna un iterator
	 */
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>=0){
			Iterator<Integer>it=this.vertice.get(pos).getIdAdyasentes().iterator();
			return it;
		}
		return null;
	}

	@Override
	/**
	 * Complejidad: O(n) ya agrega los adyasentes de todos los vertices
	 * crea y retorna un iterator
	 */
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>>aux=new ArrayList<>();
		for(int i=0;i<this.vertice.size();i++){
			aux.addAll(this.vertice.get(i).getIdAdyasentes());
		}
		Iterator it=aux.iterator();
		return it;
	}

	@Override
	/**
	 * Complejidad: O(n) ya que recorre toda la lista buscando la posicion de un vertice
	 * crea y retorna un iterator
	 */
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		int pos=this.getPosVertice(verticeId);
		if(pos>=0){
			Iterator it=this.vertice.get(pos).getListaArco().iterator();
			return it;
		}
		return null;
	}

	@Override
	/**
	 * Complejidad: O(n) ya que recorre toda la lista buscando un vertice y luego
	 * verifica que es vertice contenga adyasentes
	 */
	public boolean tieneAdaysentes(int aux) {
		int pos=this.getPosVertice(aux);
		if(pos>=0){
			if(this.vertice.get(pos).getAdyasentes().size()>=0){
				return true;
			}
		}
		return false;
	}
	/**
	 * Complejidad: O(n) ya que recorre toda la lista para verificar que exista un vertice
	 * retorna la posicion si se encuentra caso contrario retorna -1
	 */
	private int getPosVertice(int verticeId){
		for(int i=0;i<this.vertice.size();i++){
			if(this.vertice.get(i).getId()==verticeId){
				return i;
			}
		}
		return -1;
	}
	/**
	 * Complejidad: O(n) ya que recorre la lista de los vertices y la guarda en una lista auxiliar
	 * que luego retorna
	 */
	private ArrayList<Integer> getIdVertice(){
		ArrayList<Integer> aux=new ArrayList<Integer>();
		for(int i=0;i<this.vertice.size();i++){
			aux.add(this.vertice.get(i).getId());
		}
		return aux;
	}
}
