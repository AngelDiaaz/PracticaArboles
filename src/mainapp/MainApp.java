package mainapp;

import java.util.ArrayList;

import models.Arbol;
import models.Nodo;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Nodo> vacio1 = new ArrayList<Nodo>();
		ArrayList<Nodo> vacio2 = new ArrayList<Nodo>();
		ArrayList<Nodo> vacio3 = new ArrayList<Nodo>();
		ArrayList<Nodo> vacio4 = new ArrayList<Nodo>();

		Nodo cuatro = new Nodo("cuatro", vacio4);

		ArrayList<Nodo> f = new ArrayList<Nodo>();
		f.add(cuatro);
		Nodo ternera = new Nodo("ternera", f);

		Nodo tres = new Nodo("tres", vacio3);
		ArrayList<Nodo> e = new ArrayList<Nodo>();
		e.add(tres);
		Nodo cerdo = new Nodo("cerdo", e);

		Nodo seis = new Nodo("seis", vacio2);
		ArrayList<Nodo> d = new ArrayList<Nodo>();
		d.add(seis);

		Nodo cinco = new Nodo("cinco", d);
		ArrayList<Nodo> c = new ArrayList<Nodo>();
		c.add(cinco);
		Nodo dos = new Nodo("dos", c);
		Nodo uno = new Nodo("uno", vacio1);

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

		// Recorre el arbol de diferente formas
		//cabesa.postOrden();
		cabesa.preOrden();

		System.out.println();

		// Muestra la ruta del nodo a la raiz, si el nodo se encuentra en el arbol
		//cabesa.path("ternera");

		//Busca el nodo y lo devuelve si se encuentra
		//System.out.println(cabesa.buscarNodo("cerdo"));

		
		//Inserta un nodo donde queremos
		cabesa.insertarNodo(seis, "hola");
		// System.out.println(cabesa.buscarNodo("hola"));

		// Muestra el arbol de los nodos
		//cabesa.mostrarArbol();
		
		//Elimina la rama entera seleccionada
		//cabesa.podar(pollo);

		//Corta y pega el nodo donde lo queremos
		cabesa.cortarPegar(seis, ternera);
		cabesa.mostrarArbol();
		
		//Profundidad de un nodo en el arbol
		//System.out.println(cabesa.profundidad("seis"));
		
		//Muestra si el arbol esta balanceado o no
		System.out.println(cabesa.estaBalanceado());

	}

}
