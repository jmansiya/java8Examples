package com.josemansilla.java8;

import java.util.Optional;

public class OptionalClass {
	public void probar(String valor){
		System.out.println(valor.contains("jose"));
		try{
			Optional op = Optional.empty();
			
			op.get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No hay elemento");
		} 
		
	}
	
	public void orElse(String valor){
		Optional<String> op = Optional.ofNullable(valor);
		
		String x = op.orElse("Predeterminado");
		
		System.out.println(x);
	}
	
	public void orElseThrow(String valor){
		Optional<String> op = Optional.ofNullable(valor);
		op.orElseThrow(NumberFormatException::new);
	}
	
	public void isPresent(String valor){
		Optional<String> op = Optional.ofNullable(valor);
		
		System.out.println(op.isPresent());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptionalClass opClass = new OptionalClass();
		
		String valor = null;
		
		//opClass.probar(valor);
		opClass.orElse(valor);
		opClass.orElseThrow("Jose");
		opClass.isPresent("1");
	}

}
