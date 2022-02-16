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

	public String path(String valor) {
		boolean contiene = this.raiz.comprobarNodo(valor);
		if (contiene == true) {
			return this.raiz.path(valor);
		} else {
			System.out.println("No existe un nodo con ese valor en este arbol");
			return null;
		}
	}

	public void mostarArbol() {
		this.raiz.mostrarArbol(raiz);
	}
}
