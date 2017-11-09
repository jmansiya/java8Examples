package com.jose.mansilla.util;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Stream;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jose.mansilla.entities.Notas;
import com.jose.mansilla.entities.PruebaEntity;

public class ValidacionesModificacionTest {
	
	private PruebaEntity original;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		original = new PruebaEntity();
		original.setApellidos("Mansilla Garcia-Gil");
		original.setDireccion("CostaRica");
		original.setEdad(36);
		original.setNombre("Jose");
	}

	@Test
	public void test() {
		//Clonamos el objeto origianl;
		PruebaEntity modificacion = ObjectUtils.clone(original);
		
		modificacion.setApellidos("Garcia");
		modificacion.setDireccion("prueba");
		
		assertThat("Objeto clonado", modificacion, notNullValue());
		assertThat("Son diferentes", original, not(sameInstance(modificacion)));
		assertThat("Campo no cambiado", original.getNombre(), equalTo(modificacion.getNombre()));
		
	    List<Notas> notas =	Stream.of(ValidacionesModificacion.values()).filter(e -> e.getCambiado().test(original, modificacion))
		.map(e -> e.getNota().apply(original, modificacion)).collect(toList());
	
	    assertThat("Lista contiene 2 elementos", notas, hasSize(2));
	    
	    assertThat("La lista de notas no está vacia.", notas, not(empty()));
	    
		assertThat(
				notas.stream().map(e -> e.getNota()).collect(toList()),
				contains(
						"El atributo Apellidos antes tenia valor Mansilla Garcia-Gil y ahora tiene el valor Garcia",
						"El atributo Direccion antes tenia valor CostaRica y ahora tiene el valor prueba"
						)
				);
	}

}
