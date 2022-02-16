package mainapp;

import java.util.ArrayList;

import models.Arbol;
import models.Nodo;

public class MainApp {

	public static void main(String[] args) {
		
		Nodo cuatro = new Nodo("cuatro");
		
		ArrayList<Nodo> f = new ArrayList<Nodo>();
		f.add(cuatro);
		Nodo ternera = new Nodo("ternera", f);
		
		Nodo tres = new Nodo("tres");
		ArrayList<Nodo> e = new ArrayList<Nodo>();
		e.add(tres);
		Nodo cerdo = new Nodo("cerdo", e);

		Nodo seis = new Nodo("seis");
		ArrayList<Nodo> d = new ArrayList<Nodo>();
		d.add(seis);
		
		Nodo cinco = new Nodo("cinco", d);
		ArrayList<Nodo> c = new ArrayList<Nodo>();
		c.add(cinco);
		Nodo dos = new Nodo("dos", c);
		Nodo uno = new Nodo("uno");
		
		ArrayList<Nodo> b = new ArrayList<Nodo>();
		b.add(uno);
		b.add(dos);
		Nodo pollo = new Nodo("pollo", b);
		
		ArrayList<Nodo> a = new ArrayList<Nodo>();
		a.add(pollo);
		a.add(cerdo);
		a.add(ternera);
		Nodo raiz = new Nodo("~", a);
		
		Arbol cabesa = new Arbol(raiz);
		
		//cabesa.preOrden();
		//cabesa.postOrden();
		
		System.out.println(cabesa.buscarNodo("rdo"));		
		
		cabesa.path("p");
	}

}
