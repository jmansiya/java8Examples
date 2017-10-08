package com.josemansilla.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Clase para probar los stream paralelos.
 * 
 * @author josemansilla
 *
 */
public class MapAPP {
	private Map<Integer, String> mapa;
	
	public void llenar(){
		mapa = new HashMap<Integer, String>();
		
		mapa.put(1, "Mito");
		mapa.put(2, "Jose");
		mapa.put(3, "Java8Examples");
	}
	
	public void imprimir_v7(){
		for(Entry<Integer, String> e : mapa.entrySet()){
			System.out.println("Key: " + e.getKey() + " - Valor: " + e.getValue());
		}
	}
	
	public void imprimir_V8(){
		mapa.forEach((v, k) ->  System.out.println("Key " + v + " - Valor : " + k));
		
		mapa.entrySet().stream().forEach(System.out::println);
	}
	
	public void recolectar(){
		Map<Integer, String> mapaRecolecado = mapa.entrySet().stream().
					filter(e->e.getValue().contains("o")).
					collect(Collectors.toMap(p->p.getKey(),  p-> p.getValue()));
		
		mapaRecolecado.entrySet().forEach(System.out::println);
	}
	
	public void insertarSiAusente(){
		mapa.putIfAbsent(43, "Antonio");
	}
	
	public void operarSiPresente(){
		mapa.computeIfPresent(3, (k, v) -> k + v);
	}
	
	public void obgenerOrPredeterminado(){
		//Si no existe podemos poner un valor por defecto.
		String valor = mapa.getOrDefault(34, "Por defecto");
		
		System.out.println(valor);
	}
	
	public static void main(String[] args) {
		MapAPP app = new MapAPP();
		
		app.llenar();
		app.imprimir_v7();
		System.out.println("$$$$$");
		app.imprimir_V8();
		System.out.println("$$$$$");
		app.insertarSiAusente();
		
		app.imprimir_V8();
		
		System.out.println("$$$$$");
		app.operarSiPresente();
		
		app.imprimir_V8();
		System.out.println("$$$$$");
		app.obgenerOrPredeterminado();
		
		System.out.println("$$$$$");
		app.recolectar();
	}

}
