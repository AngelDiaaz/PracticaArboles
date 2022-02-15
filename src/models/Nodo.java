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

	public boolean tieneHijos(Nodo n) {
		if (n.hijos == null) {
			return false;
		} else {
			return true;
		}

		// return n.hijos.get(0) != null;

	}

	public void preOrden(Nodo n) {
		System.out.print(n.getValor() + "/");

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijos.size(); i++) {
				preOrden(n.hijos.get(i));
			}
		}
	}

	public void postOrden(Nodo n) {

		if (tieneHijos(n)) {
			for (int i = 0; i < n.hijos.size(); i++) {
				postOrden(n.hijos.get(i));
			}
		}
		System.out.print(n.getValor() + "/");
	}
	
	
	
	

	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}

}
