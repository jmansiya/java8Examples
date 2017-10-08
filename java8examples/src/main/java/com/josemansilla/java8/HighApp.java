package com.josemansilla.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp{
	private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String, String> convertirMinusculas = x -> x.toLowerCase(); 
	private Function<String, String> concatenar = x -> x.concat(" - Prueba JOSE");
	
	public void imprimir(Function<String, String> funcion, String valor){
		System.out.println(funcion.apply(valor));
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud){
		lista.stream().filter(this.establecerLogicaFiltro(longitud))
			.forEach(consumidor);
	}
	
	public void filtrar(List<String> lista, Consumer<String> consumidor, String cadena){
		lista.stream().filter(this.establecerLogicaFiltro(cadena))
			.forEach(consumidor);
	}
	
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	public static void main(String[] args) throws InterruptedException {
		HighApp app = new HighApp();
		
		Function<String, String> funcionCompuesta = app.concatenar.compose(app.convertirMinusculas);
		Function<String, String> funcionAndThen = x -> "Final : " + x;
		
		app.imprimir(app.convertirMayusculas, "hola prueba");
		app.imprimir(app.convertirMinusculas, "MINUSCULAS");
		
		app.imprimir(funcionCompuesta, "FUNCION COMPUESTA DE JOSE.");
		
		String value = funcionCompuesta.andThen(funcionAndThen).apply("Función compuesta AND then example");
		
		System.out.println(" --- " + value);
		
		System.out.println(" #########  ");
		List<String> lista = new ArrayList<>();
		lista.add("Jose");
		lista.add("Mansilla");
		lista.add("GarciaGil");
		lista.add("Arquitecto de Software");
		
		app.filtrar(lista, System.out::println, 10);
		
		app.filtrar(lista, System.out::println, "ans");
	}

}




