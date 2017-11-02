package com.jose.mansilla.futuros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FuturosTest {

	@Mock
	CompletableFuture<String> fut1;
	
	@Mock
	CompletableFuture<String> fut2;
	
	@Mock
	CompletableFuture<String> fut3;
	
	private final String CADENA1 = "cadena 1";
	private final String CADENA2 = "cadena 2";
	
	private Futuros futuro = new Futuros();
	
	@Before
	public void setup(){

	}
	
	@Test
	public void testFuturo1() {
		try {
		   	CompletableFuture<String> test = futuro.getFuturo1(CADENA1);
		   	
		   	assertEquals(CADENA1, test.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFuturo2() {
		try {
		   	CompletableFuture<String> test = futuro.getFuturo2(CADENA2);
		   	
		   	assertEquals(CADENA2, test.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCombineFuturos() {
		try {
			CompletableFuture<String> combinacion = futuro.combineFutures(futuro.getFuturo1(CADENA1), futuro.getFuturo2(CADENA2));
		   	
			assertEquals(CADENA1 + CADENA2, combinacion.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCombinacionFuturos() {
		try {
			when(fut1.get()).thenReturn(CADENA1);
			when(fut2.get()).thenReturn(CADENA2);
			when(fut3.get()).thenReturn(CADENA1 + CADENA2);
			BiConsumer<String, Exception> calcResults = (f, s) -> {System.out.println(f);};
			BinaryOperator<String> calcFinal = (f, s) -> CADENA1 + CADENA2;
			
			when(fut1.thenCombineAsync(fut2, calcFinal)).thenReturn(fut3);
			when(futuro.combineFutures(fut1, fut2)).thenReturn(fut3);
			
			futuro.combinacionFuturos(CADENA1, CADENA2);
			
			assertEquals(CADENA1 + CADENA2, fut3.get()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*
	 * Para testear un método runAsync que no retorna ningún valor:
	 * 
	 * CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println("running async task"), service);
        pauseSeconds(1);
        assertThat(runAsync.isDone(), is(true));
	 */
	 
}
