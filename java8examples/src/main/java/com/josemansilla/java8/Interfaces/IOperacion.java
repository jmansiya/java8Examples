package com.josemansilla.java8.Interfaces;

@FunctionalInterface
public interface IOperacion {
	public double calcularPromedio(double n1, double n2);
	
	public default void getNombreOperacion(){
		System.out.println("IOperacion 1");
	}
}

