package com.josemansilla.java8;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;


/**
 * Clase para probar RxJava Programación reactiva de Java.
 * 
 * @author josemansilla
 *
 */
public class RxApp {
	private List<Integer> lista1;
	private List<Integer> lista2;
	
	public RxApp(){
		lista1 = new ArrayList<>();
		lista2 = new ArrayList<>();
		
		this.llenarListas();
	}
	
	public void llenarListas(){
		for(int i = 0; i < 10; i++){
			lista1.add(i);
			lista2.add(i);
		}
	}
	
	public void buscar(){
		Observable<Integer> obsLista1 = Observable.from(lista1);
		Observable<Integer> obsLista2 = Observable.from(lista2);
		
		Observable.merge(obsLista1, obsLista2).filter(x -> x == 1).subscribe(System.out::println);
		
		System.out.println(" #### ");
		
		Observable.merge(obsLista1, obsLista2).subscribe(x ->{
			if (x == 1){
				System.out.println(x);
			}
		});
		
//		Observable.merge(obsLista1, obsLista2).subscribe(new Action1<Integer>() {
//
//			@Override
//			public void call(Integer t) {
//				// TODO Auto-generated method stub
//				if (t == 1){
//					System.out.println(t);
//				}
//			}
//		});
	}
	
	public static void main(String[] args) {
		RxApp app = new RxApp();
		
		//app.llenarListas();
		app.buscar();
		
//		List<String> lista = new ArrayList<>();
//		lista.add("Jose");
//		lista.add("Mansilla");
//		lista.add("GarciaGil");
//		
//		Observable<String> obsString = Observable.from(lista);
//		obsString.subscribe(new Action1<String>() {
//
//			@Override
//			public void call(String t) {
//				// TODO Auto-generated method stub
//				System.out.println(t);
//			}		
//		});
	}

}
