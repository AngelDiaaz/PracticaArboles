package models;

import java.util.ArrayList;

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
	 * 
	 * @param valor Valor del nodo que queremos encontrar
	 * @return Nodo que queriamos buscar o null si no lo contiene
	 */

	public Nodo buscarNodo(String valor) {
		if (this.raiz.comprobarNodo(valor)) {// Compruebo si el nodo se encuentra en el arbol
			return this.raiz.buscarNodo(valor);
		} else {
			System.out.println("No existe este nodo en este arbol");
			return null;
		}
	}

	/**
	 * Inserta un nodo hijo en el nodo padre que nosotros queramos
	 * 
	 * @param padre Nodo al que queremos insertarle un nodo hijo
	 * @param valor Valor del nodo que queremos insertar
	 */

	public void insertarNodo(Nodo padre, String valor) {
		boolean contiene = this.raiz.comprobarNodo(padre.getValor());
		if (contiene == true) {
			this.raiz.insertarNodo(padre, valor);
		} else {
			System.out.println("No existe el nodo padre en este arbol");
		}
	}

	/**
	 * Llama al metodo path de la clase Nodo
	 * 
	 * @param valor Valor del nodo hasta donde queremos mostrar la ruta
	 * @return Ruta del nodo si lo contiene el arbol
	 */

	public void path(String valor) {
		if (this.raiz.comprobarNodo(valor)) {// Compruebo si el nodo se encuentra en el arbol
			var almacen = this.raiz.path(valor, new ArrayList<String>());

			for (int i = almacen.size() - 1; i >= 0; i--) {
				System.out.print(almacen.get(i) + "/");
			}
			System.out.println(valor + "/");

		} else {
			System.out.println("No existe un nodo con ese valor en este arbol");
		}
	}

	/**
	 * Muestra el path de todos los nodos en recorrido preOrden, reproduciendose el
	 * arbol con todos los nodos
	 */

	public void mostarArbol() {
		var nodos = this.raiz.sacarNodos(raiz);// Almacena todos los nodos
		for (Nodo nodo : nodos) {
			path(nodo.getValor()); // Saca el path de todos los nodos del arbol
		}
	}

	/**
	 * Elimina la rama desde el nodo concreto de un arbol, llamando al metodo podar
	 * de la clase nodo
	 * @param n Nodo concreto a partir del que queremos eliminar
	 */

	public void podar(Nodo n) {
		this.raiz.podar(n.getValor());
	}
}
