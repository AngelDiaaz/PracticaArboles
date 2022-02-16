package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private ArrayList<Nodo> hijos;

	public Nodo(String valor) {
		super();
		this.valor = valor;
	}

	public Nodo(String valor, ArrayList<Nodo> hijos) {
		super();
		this.valor = valor;
		this.hijos = hijos;
	}

	public String getValor() {
		return valor;
	}

	public ArrayList<Nodo> getHijos() {
		return hijos;
	}

	/**
	 * Comprueba si el nodo tiene nodos hijos o no
	 * @param n Nodo a comprobar si tiene hijos
	 * @return True si tiene hijos y false si no los tiene
	 */
	
	public boolean tieneHijos(Nodo n) {
		if (n.hijos == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Muestra el arbol con el recorrido preOrden, empezando por la raiz y siguiendo por los nodos hijos
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
	 * Muestra el arbol en recorrido postOrden, empezando por los nodos hijos y,luego por la raiz
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
	 * Comprueba si un nodo esta en el arbol
	 * @param valor Valor del nodo que queremos buscar
	 * @return True si el nodo esta en el arbol y false si no lo esta
	 */
	
	public boolean comprobarNodo(String valor) {
		Nodo aux = buscarNodo(valor);
		
		if(aux != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Te muestra la ruta desde la raiz hasta el nodo
	 * @param valor Valor del nodo hasta donde queremos mostrar la ruta
	 * @return Valor del nodo
	 */

	public String path(String valor) {
			System.out.print(this.valor + "/");
			if (this.valor.equals(valor)) {
				return this.getValor();
			}
			if (tieneHijos(this)) {
				for (int i = 0; i < this.hijos.size(); i++) {

					var n = this.hijos.get(i).path(valor);
					if (n != null) {
						return n;
					}
				}
			}
			return null;
	}

	public void mostrarArbol(Nodo n) {

	}

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

}
