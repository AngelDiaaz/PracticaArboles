package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private ArrayList<Nodo> hijos;
	private ArrayList<Nodo> arbol;

	public Nodo(String valor, ArrayList<Nodo> hijos) {
		super();
		this.valor = valor;
		this.hijos = hijos;
		this.arbol = new ArrayList<Nodo>();
	}

	public String getValor() {
		return valor;
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	/**
	 * Comprueba si el nodo tiene nodos hijos o no
	 * 
	 * @param n Nodo a comprobar si tiene hijos
	 * @return True si tiene hijos y false si no los tiene
	 */

	public boolean tieneHijos(Nodo n) {
		return this.hijos != null;
	}

	/**
	 * Muestra el arbol con el recorrido preOrden, empezando por la raiz y siguiendo
	 * por los nodos hijos
	 * 
	 * @param n Nodo que quieres sacar
	 */

	public void preOrden(Nodo n) {
		System.out.print(n.getValor() + "/");

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijos.size(); i++) {
				preOrden(n.hijos.get(i));
			}
		}
	}

	/**
	 * Muestra el arbol en recorrido postOrden, empezando por los nodos hijos
	 * y,luego por la raiz
	 * 
	 * @param n Nodo que quieres sacar
	 */

	public void postOrden(Nodo n) {

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijos.size(); i++) {
				postOrden(n.hijos.get(i));
			}
		}
		System.out.print(n.getValor() + "/");
	}

	/**
	 * Busca un nodo en el arbol
	 * 
	 * @param valor Valor del nodo que quiere buscar
	 * @return Nodo que quereis obtener o null sino encuentra el nodo en el arbol
	 */
	public Nodo buscarNodo(String valor) {

		if (this.valor.equals(valor)) {
			return this;
		}
		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {

				var n = this.hijos.get(i).buscarNodo(valor);
				if (n != null) {
					return n;
				}
			}
		}
		return null;
	}

	/**
	 * Inserta un nodo hijo en el nodo padre que nosotros queramos
	 * 
	 * @param padre Nodo al que queremos insertarle un nodo hijo
	 * @param valor Valor del nodo que queremos insertar
	 * @return Nodo que queremos insertar
	 */

	public Nodo insertarNodo(Nodo padre, String valor) {
		if (this.valor.equals(padre.valor)) {
			ArrayList<Nodo> vacio = new ArrayList<Nodo>();// Creamos un array list vacio para agregarselo al nuevo nodo,
															// por si luego queremos a?adir a ese nodo, nodos hijos
			this.hijos.add(0, new Nodo(valor, vacio));
			return this;
		}
		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {

				var n = this.hijos.get(i).insertarNodo(padre, valor);
				if (n != null) {
					return n;
				}
			}
		}
		return null;
	}

	/**
	 * Comprueba si un nodo esta en el arbol
	 * 
	 * @param valor Valor del nodo que queremos buscar
	 * @return True si el nodo esta en el arbol y false si no lo esta
	 */

	public boolean comprobarNodo(String valor) {
		Nodo aux = buscarNodo(valor);

		if (aux != null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Te muestra la ruta desde la raiz hasta el nodo
	 * 
	 * @param valor Valor del nodo hasta donde queremos mostrar la ruta
	 * @return Valor del nodo
	 */

	public ArrayList<String> path(String valor, ArrayList<String> path) {
		if (this.valor.equals(valor)) {
			return path;
		}
		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {
				var n = this.hijos.get(i).path(valor, path);
				if (n != null) {
					path.add(this.valor);
					return n;
				}
			}
		}
		return null;
	}

	/**
	 * Alamacena todo los nodos del arbol en un array list en modo preOrden
	 * 
	 * @param n Nodo que quiero almacenar
	 * @return ArrayList con todos los nodos del arbol en forma preOrden
	 */

	public ArrayList<Nodo> sacarNodos(Nodo n) {
		arbol.add(n);
		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijos.size(); i++) {
				sacarNodos(n.hijos.get(i));
			}
		}
		return arbol;
	}

	/**
	 * Elimina la rama desde el nodo concreto de un arbol
	 * 
	 * @param valor Valor del nodo concreto que a partir de ahi queremos eliminar
	 * @return Nodo concreto
	 */

	public Nodo podar(String valor) {
		if (this.valor.equals(valor)) {
			return this;
		}
		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {
				var n = this.hijos.get(i).podar(valor);
				if (n != null) {
					this.hijos.remove(n);// Cuando encuentre el nodo que queremos podar eliminamos ese nodo y a su vez
											// elimina sus nodos hijos
					return n;
				}
			}
		}
		return null;
	}

	/**
	 * Corta y pega un nodo a otro nodo, se elige un objeto nodo y se cambia su
	 * padre. De esta forma, el nodo origen pasa a ser un nuevo hijo de nodo
	 * destino.
	 * 
	 * @param origen  Nodo que queremos cambiar de padre
	 * @param destino Nodo padre que queremos a?adirle un nuevo nodo hijo
	 * @return Nodo destino
	 */

	public Nodo cortarPegar(Nodo origen, Nodo destino) {
		podar(origen.valor);
		if (this.valor.equals(destino.valor)) {
			this.getHijos().add(origen);
			return this;
		}

		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {
				var n = this.hijos.get(i).cortarPegar(origen, destino);
				if (n != null) {
					return n;
				}
			}
		}
		return null;
	}

	/**
	 * Comprueba si un nodo es hoja, es decir, si el nodo no tiene hijos y es la
	 * ultima de la rama de un arbol
	 * 
	 * @return True si es hoja y false si no lo es
	 */

	public boolean esHoja() {

		if (this.hijos.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Muestra la profundidad que tiene un nodo en el arbol, contando con la raiz
	 * que este en el nivel 0
	 *
	 * @param valor Valor de nodo que queremos mostrar la profundidad
	 * @param prof Profundidad inicial del nodo 
	 * @return Nivel de profundidad del nodo
	 */

	public int profundidad(String valor, int prof) {
		if (this.valor.equals(valor)) {
			return prof;
		}

		if (tieneHijos(this)) {
			for (int i = 0; i < this.hijos.size(); i++) {

				var n = this.hijos.get(i).profundidad(valor, ++prof);
				if (n != -1)
					return n;
				else
					--prof;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

}
