package com.jose.mansilla.util;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import com.jose.mansilla.entities.Notas;
import com.jose.mansilla.entities.PruebaEntity;

public enum ValidacionesModificacion{
	NOMBRE((a, b) -> !equalsIgnoreCase(a.getNombre(), b.getNombre()), 
		(a, b) -> getMensaje("Nombre", a.getNombre(), b.getNombre())
	),
	APELLIDOS((a, b) -> !equalsIgnoreCase(a.getApellidos(), b.getApellidos()),
		(a, b) -> getMensaje("Apellidos", a.getApellidos(), b.getApellidos())
	),
	DIRECCION((a, b) -> !equalsIgnoreCase(a.getDireccion(), b.getDireccion()),
			(a,b) -> getMensaje("Direccion", a.getDireccion(), b.getDireccion()));
	
	private static final String MENSAJE = "El atributo {0} antes tenia valor {1} y ahora tiene el valor {2}";
	
	private static Notas getMensaje(String campo, String valorInicial, String valorFinal){
		Notas nota = new Notas();
		nota.setNota(format(MENSAJE, campo, valorInicial, valorFinal));
		return nota;
	}
	
	private BiPredicate<PruebaEntity, PruebaEntity> cambiado;
	private BiFunction<PruebaEntity, PruebaEntity, Notas> nota;
	
	private ValidacionesModificacion(BiPredicate<PruebaEntity, PruebaEntity> modificado,
			BiFunction<PruebaEntity, PruebaEntity, Notas> nota) {
		this.cambiado = modificado;
		this.nota = nota;
	}
	
	public BiPredicate<PruebaEntity, PruebaEntity> getCambiado() {
		return cambiado;
	}
	
	public BiFunction<PruebaEntity, PruebaEntity, Notas> getNota() {
		return nota;
	}
	
};
