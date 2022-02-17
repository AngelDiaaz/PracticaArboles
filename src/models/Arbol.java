package models;

public class Arbol {

	private Nodo raiz;

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	/**
	 * Llama al metodo preOrden de la clase Nodo
	 */

	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	/*
	 * Llama al metdo postOrden de la clase Nodo
	 */

	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	/**
	 * Llama al metodo buscarNodo de la clase Nodo
	 * @param valor Valor del nodo que queremos encontrar
	 * @return Nodo que queriamos buscar o null si no lo contiene
	 */

	public Nodo buscarNodo(String valor) {
		return this.raiz.buscarNodo(valor);
	}
	
	/**
	 * Inserta un nodo hijo en el nodo padre que nosotros queramos
	 * @param padre Nodo al que queremos insertarle un nodo hijo
	 * @param valor Valor del nodo que queremos insertar
	 */
	
	public void insertarNodo(Nodo padre, String valor) {
		boolean contiene = this.raiz.comprobarNodo(padre.getValor());
		if(contiene == true) {
			this.raiz.insertarNodo(padre, valor);
		} else {
			System.out.println("No existe el nodo padre en este arbol");
		}
	}
	
	/**
	 * Llama al metodo path de la clase Nodo
	 * @param valor Valor del nodo hasta donde queremos mostrar la ruta
	 * @return Ruta del nodo si lo contiene el arbol
	 */

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
