package com.josemansilla.java8.Interfaces;

@FunctionalInterface
public interface IOperacion2 {
	public double calcular(double n1, double n2);
	
	public default void getNombreOperacion(){
		System.out.println("IOperacion 2");
	}
}

