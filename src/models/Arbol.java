package models;

public class Arbol {
	
	private Nodo raiz;

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}

	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	public Nodo buscarNodo(String valor) {
		return this.raiz.buscarNodo(valor);
	}
	
	public void mostarArbol() {
		this.raiz.mostrarArbol(raiz);
	}
}
