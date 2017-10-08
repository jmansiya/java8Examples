package com.josemansilla.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.josemansilla.java8.Interfaces.IOperacion;
import com.josemansilla.java8.Interfaces.IOperacion2;

public class LambdaApp implements IOperacion, IOperacion2{
	private List<String> listaString;
	private List<String> listaNumeros;
		
	
	public void ordenar(){
		List<String> lNombres = new ArrayList<>();
		lNombres.add("Jose");
		lNombres.add("Lucia");
		lNombres.add("Maribel");
		
		/*
		 * Versión comparación elementos de una lista antes de java8
		 *
		Collections.sort(lNombres, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		}); */
	
	//	Collections.sort(lNombres, (String p1, String p2) -> p2.compareTo(p1));		
		
	/*	for(String elemento: lNombres){
			System.out.println(elemento);
		}
		*/
		
		//IOperacion operacion = (double x, double y) -> (x + y) / 2;
		
		IOperacion2 operacion = (x, y) -> {
			double a = 2.0;
			System.out.println(a);
			
			return (x + y) / 2 + a;
		};
		
		System.out.println("Promedio : " + operacion.calcular(2, 3));
		
		operacion.getNombreOperacion();
	}

	public double probarLocalVariable(){
		double n3 = 3;  //Se comportará siempre dentro de la función lambda como una final.
		IOperacion operacion = (x, y) -> {
			//n3 = x + y;
			return n3 + x + y;
		};
		
		return operacion.calcularPromedio(3, 5);
	}	

	@Override
	public double calcular(double n1, double n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcularPromedio(double n1, double n2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getNombreOperacion() {
		// TODO Auto-generated method stub
		IOperacion.super.getNombreOperacion();
	}

	public List<String> rellenarLista(){
		List<String> lNombres = new ArrayList<>();
		lNombres.add("Jose");
		lNombres.add("Lucia");
		lNombres.add("Maribel");
		lNombres.add("Victor");
		
		
		return lNombres;
	}
	
	public void usarForEach(List<String> lista){
		lista.forEach(x -> System.out.println(x));
		
//		lista.forEach(System.out::println);
	}
	
	public void usarRemoveIF(List<String> lista){
		lista.removeIf(x -> x.equalsIgnoreCase("jose"));
		
		lista.forEach(System.out::println);
	}
	
	public void rellenarStreamApp(){
		listaNumeros = new ArrayList<String>();
		listaNumeros.add("1");
		listaNumeros.add("5");
		
		listaString = new ArrayList<>();
		listaString.add("Jose");
		listaString.add("Lucia");
		listaString.add("Maribel");
	}
	
	public void filtrar(){
		Predicate<String> p = x -> x.equalsIgnoreCase("Jose");
		
		listaString.stream().filter(x -> x.equalsIgnoreCase("Jose")).forEach(System.out::println);		
	}
	
	public void ordenarStream(){
		//Ascendente.
		listaString.stream().sorted().forEach(System.out::println);
		//Descendente
		listaString.stream().sorted((x, y) -> y.compareToIgnoreCase(x)).forEach(System.out::println);
	}
	
	public void transformar(){
		listaString.stream().map(String::toUpperCase).forEach(System.out::println);
		
//		Antes de java 8
//		for(String x : listaNumeros){
//			int num = Integer.parseInt(x) + 1;
//			
//			System.out.println(num);
//		}
		
		listaNumeros.stream().map(x -> Integer.parseInt(x) + 10).forEach(System.out::println);
		
	}
	
	public void SumarTotalNumeros(){
		System.out.println(listaNumeros.stream().map(x -> Integer.parseInt(x)).reduce(3, (x, y ) -> x + y));
	}
	
	public void contarElementosLista(){
		System.out.println("Numeros: " + listaNumeros.stream().count());
		System.out.println("String: " + listaString.stream().count());
	}
	
	
	public static void main(String[] args) {
		LambdaApp app = new LambdaApp();
		
		app.rellenarStreamApp();
		System.out.println("=====");
		app.filtrar();
		System.out.println("=====");
		app.ordenarStream();
		System.out.println("=====");
		app.transformar();
		System.out.println("=====");
		app.contarElementosLista();
		System.out.println("=====");
		app.SumarTotalNumeros();
		/*
		List<String> lista = app.rellenarLista();
		app.usarForEach(lista);
		System.out.println("Eliminamos....");
		app.usarRemoveIF(lista);
		/*
		app.ordenar();
		
		System.out.println( app.probarLocalVariable() );
		
		app.getNombreOperacion();*/
		
		
	}

}




