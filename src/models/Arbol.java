package models;

import java.util.ArrayList;

public class Arbol {

	private Nodo raiz;
	private ArrayList<Integer> aux;

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
		this.aux = new ArrayList<Integer>();
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

	public void mostrarArbol() {
		var nodos = this.raiz.sacarNodos(raiz);// Almacena todos los nodos
		for (Nodo nodo : nodos) {
			path(nodo.getValor()); // Saca el path de todos los nodos del arbol
		}
	}

	/**
	 * Elimina la rama desde el nodo concreto de un arbol, llamando al metodo podar
	 * de la clase nodo
	 * 
	 * @param n Nodo concreto a partir del que queremos eliminar
	 */

	public void podar(Nodo n) {
		if (this.raiz.comprobarNodo(n.getValor())) {// Compruebo si el nodo se encuentra en el arbol
			this.raiz.podar(n.getValor());
		} else {
			System.out.println("No existe un nodo con ese valor en este arbol");
		}
	}

	/**
	 * Corta y pega un nodo a otro nodo, se elige un objeto nodo y se cambia su
	 * padre. De esta forma, el nodo origen pasa a ser un nuevo hijo de nodo
	 * destino.
	 * 
	 * @param origen  Nodo que queremos cambiar de padre
	 * @param destino Nodo padre que queremos añadirle un nuevo nodo hijo
	 */

	public void cortarPegar(Nodo origen, Nodo destino) {
		this.raiz.cortarPegar(origen, destino);
	}

	/**
	 * Muestra la profundidad que tiene un nodo en el arbol, contando con la raiz
	 * que este en el nivel 0
	 * 
	 * @param valor Valor de nodo que queremos mostrar la profundidad
	 * @return Nivel de profundidad del nodo
	 */

	public int profundidad(String valor) {
		return this.raiz.profundidad(valor, 0);
	}

	/**
	 * Dice si un arbol esta balanceado, es decir, si sus hojas nunca difieren en
	 * mas de 1 nivel de profundidad
	 * 
	 * @return True si el arbol esta balanceado y false si no lo esta
	 */

	public boolean estaBalanceado() {
		ArrayList<Nodo> nodos = raiz.sacarNodos(raiz);// Almaceno todos los nodos en el array

		for (Nodo nodo : nodos) {
			if (nodo.esHoja()) {// Compruebo cual nodo es una hoja y cual no
				aux.add(profundidad(nodo.getValor()));
			}
		}

		for (int i = 0; i < aux.size(); i++) {
			for (int j = 0; j < aux.size(); j++) {
				if ((aux.get(i) - aux.get(j)) < -1 || (aux.get(i) - aux.get(j)) > 1) {// Si la diferencia de nodos es
																						// diferente a 1
					return false;
				}
			}
		}
		return true;
	}

}
