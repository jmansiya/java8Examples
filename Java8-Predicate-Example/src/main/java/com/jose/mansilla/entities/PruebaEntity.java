package com.jose.mansilla.entities;

public class PruebaEntity implements Cloneable{
	private String nombre;
	private String apellidos;
	private String direccion;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		PruebaEntity clone=(PruebaEntity) super.clone();
	    
		return clone;
	}
	
}
