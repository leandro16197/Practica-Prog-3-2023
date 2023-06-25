package Practico_3_2;

public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	@Override
	public boolean equals(Object o) {
		Arco a = (Arco) o;
		if (this.verticeOrigen == a.getVerticeOrigen() && this.verticeDestino == a.getVerticeDestino()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return " Arco Vertice Origen "+ verticeOrigen +" , Vertice Destino " + verticeDestino +" Etiqueta " + etiqueta;
	}
}
