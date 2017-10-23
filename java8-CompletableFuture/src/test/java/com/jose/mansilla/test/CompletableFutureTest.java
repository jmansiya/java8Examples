package com.jose.mansilla.test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jose.mansilla.Sleep;

public class CompletableFutureTest {
	private final static Logger LOGGER = LoggerFactory.getLogger(CompletableFutureTest.class);

	private ExecutorService executor;
	
	@Before
	public void setUp() throws Exception {
		//Creamos un pool de 10 hilos en total.
		executor = Executors.newFixedThreadPool(10);
	}
	
	@After
	public void shutDown() throws InterruptedException {
		Sleep.sleepSeconds(5);
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);
	}
	
	@Ignore //@Test
	public void testFutureCreationNew(){
		CompletableFuture<String> future = new CompletableFuture<String>();
		LOGGER.info("Completable Creado...");
		
		future.whenCompleteAsync((s, e) -> LOGGER.info("Resultado: " + s), executor);
		
		LOGGER.info("Registrado el when complete async");
		Sleep.sleepSeconds(2);
		future.complete("Completado");
	}
	
	@Ignore //@Test
    public void testFutureCreationRunAsync() {
        CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> {
            LOGGER.info("Comenzando runAsync...");
            Sleep.sleepSeconds(3);
            LOGGER.info("Terminado runAsync!");
        }, executor);

        futureAsync.whenCompleteAsync((s, e) -> LOGGER.info("Sin resultado..."), executor);
        LOGGER.info("Terminado main thread");
    }
	
	@Ignore //@Test
    public void testFutureCreationSupplyAsync() {
    	Instant ini = Instant.now();
        CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Comenzando supplyAsync...");
            Sleep.sleepSeconds(4);
            LOGGER.info("Terminado supplyAsync!");
            return "Terminado";
        }, executor);

        futureAsync.whenCompleteAsync((s, e) -> {
        	LOGGER.info("Resultado supplyAsync: " + s);
        	Instant fin = Instant.now();
        	
        	System.out.println("Duración: " + Duration.between(ini, fin).toMillis());
        	}, executor);
        
        LOGGER.info("Terminado main thread");
    }

	@Ignore //@Test
    public void testFutureCreationSupplyAsyncBlocking() throws Exception {
        CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("Comenzando supplyAsyncBlocking...");
            Sleep.sleepSeconds(3);
            LOGGER.info("Terminado supplyAsyncBlocking!");
            return "Terminado";
        }, executor);

        LOGGER.info("Resultado bloqueando supplyAsync: " + futureAsync.get());
        
        LOGGER.info("Hemos terminado con la clase Completable.");
    }
    
	@Ignore //@Test
    public void testThenApplyFuture() throws Exception {
    	LOGGER.info("Comenzamos el Test. testThenApplyFuture");
    	CompletableFuture<String> futureAsyn = CompletableFuture.supplyAsync(() -> { 
    			LOGGER.info("Comenzando supplyAsync for thenApply.");
    			Sleep.sleepSeconds(2);
    			LOGGER.info("Terminando supplyAsyn for thenAply.");
    			
    			return "Terminado";
    	}, executor);
    	
    	CompletableFuture<String> futureApply =futureAsyn.thenApplyAsync(s -> {
    		LOGGER.info("thenFutureApply - Inicio.");
    		Sleep.sleepSeconds(3);
    		LOGGER.info("thenFutureApply - Terminando.");
    		
    		return s.toUpperCase();
    	}, executor);
    	
    	futureApply.whenComplete((s, e) -> {
    		LOGGER.info("Resultado final: {}", s);
    	});
    	
    	LOGGER.info("Hemos terminado con el hilo principal.!!");
    }
    
	@Ignore
    public void testTratamientoExeptionsWithexceptionally() throws Exception {
    	CompletableFuture<String> futureAsync = CompletableFuture.supplyAsync(() -> {
    		LOGGER.info("Comenzamos en el test de exceptions with exceptionally.");
    		Sleep.sleepSeconds(1);
    		LOGGER.info("Vamos a generar una excepción ");
    		return "" + (3 / 0);
    	}, executor);
    	
    	/*
    	 * 3ra opción definimos un handle que nos registrará un callback paa gestionar el resultado
    	 * o excepción.
    	 */
    	
    	CompletableFuture<String> futureAsyncHandle = futureAsync.handleAsync((s, e) -> {
    		if (e != null){
    			LOGGER.error("Se ha producido un error en la completable future original.", e);
    			return "Valor por defecto.";
    		} else {
    			LOGGER.info("No se ha producido ningún error.");
    			return s;
    		}
    	}, executor);
    	
    	futureAsyncHandle.whenCompleteAsync((s, e) -> LOGGER.info("RESULTADO: {}", s), 
    			executor);
    	
    	/*
    	 * 2do forma de capturar excepciones, crear un método exceptionally del CompletableFuture.
    	 * 
    	 * Esta opción es interesante si deseamos seguir con la ejecución con un valor por defecto
    	 * por ejemplo.
    	 *
    	CompletableFuture<String> futureException = futureAsync.exceptionally(e -> {
    		LOGGER.error("Se ha producido una excepción en la llamada a future.", e);
    		
    		return "Valor por defecto";
    	});
    	
    	futureException.whenComplete((s, e) -> {
    		LOGGER.info("Venimos de la excepcion. " + s);
    	});
    	*/
    	
    	//1era forma de controlar excepciones: Dentro del whenComplete directamente
    	//nos llegarán las excepciones
    	//en el segundo parámetro de la función lambda.
//    	futureAsync.whenComplete((s, e) -> {
//    		if (e != null){
//    			LOGGER.error("Se ha producido un error en el completableFuture. ", e);
//    		} else {
//    			LOGGER.info("Resultado obtenido {}", s);
//    		}
//    	});
    	
    }

	@Ignore
	public void testCombinedFutures() throws Exception{
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Comenzamos el primer futuro!.");
			Sleep.sleepSeconds(1);
			LOGGER.info("Terminamos el primer futuro!.");
			return "Terminado 1er futuro." + (1 / 0);
		}, executor);
		
		CompletableFuture<String> segundoFuturo = 
				future1.thenComposeAsync(s -> CompletableFuture.supplyAsync(() -> {
						LOGGER.info("Comenzamos el segundo futuro, parametro de entrada: " + s);
						Sleep.sleepSeconds(1);
						LOGGER.info("Terminamos el segundo futuro.");
						return s.concat(" Finalizamos segundo futuro.");						
					}, executor)
				, executor);
		
		segundoFuturo.whenComplete((s, e) -> {
			if(e != null){
				LOGGER.error("SE ha producido una excepción", e);
			} else {
				LOGGER.info("Se ha ejecutado correctamente la secuencia de futuros. RESULTADO: {} ", s);
			}
		});
	}
	
	@Ignore
	public void testThenCombineFutures() throws Exception{
		//En este caso en vez de una cadena de futuros, esperaremos a que terminen dos futuros, par aluego hacer
		//algo con ellos.
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Comenzamos el primer futuro!.");
			Sleep.sleepSeconds(1);
			LOGGER.info("Terminamos el primer futuro!.");
			return "Terminado 1er futuro.";
		}, executor);
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Comenzamos el segundo futuro!.");
			Sleep.sleepSeconds(1);
			LOGGER.info("Terminamos el segundo futuro!.");
			return "Terminado 2do futuro.";
		}, executor);
		
		CompletableFuture<String> combineFutures =
				future1.thenCombineAsync(future2, (s1, s2) -> {
					LOGGER.info("En el theCombine, recibidos resultados {} {} ", s1, s2);
					
					return s1 + s2;
				}, executor);
		
		combineFutures.whenCompleteAsync((s, e) -> {
			LOGGER.info("Resultado de la combinación: " + s);
		}, executor);
		
		/*
		 * Las funciones thenAcceptBoth y runAfterBoth son muy similares al thenCombine, excepto que
		 * no genera un nuevo futuro, simplemente ejectuan la lambda cuadno los dos futuros terminen
		 * Es como un whenComplete pero esperando dos futuros.
		 */
		// thenAcceptBoth
		CompletableFuture<String> future1a = CompletableFuture.supplyAsync(() -> {
		    LOGGER.info("Comenzando future1a for thenAcceptBoth...");
		    Sleep.sleepSeconds(2);
		    LOGGER.info("Terminado future1a for thenAcceptBoth!");
		    return "Terminado";
		}, executor);
		 
		CompletableFuture<String> future2a = CompletableFuture.supplyAsync(() -> {
		    LOGGER.info("Comenzando future2a for thenAcceptBoth...");
		    Sleep.sleepSeconds(1);
		    LOGGER.info("Terminado future2a for thenAcceptBoth!");
		    return "Terminado other";
		}, executor);
		 
		future1a.thenAcceptBothAsync(future2a, (s1, s2) ->
		                LOGGER.info("En el thenAcceptBoth, recibidos results: {}, {}", s1, s2)
		        , executor);
		 
		// runAfterBoth
		CompletableFuture<Void> future1b = CompletableFuture.runAsync(() -> {
		    LOGGER.info("Comenzando future1b for runAfterBoth...");
		    Sleep.sleepSeconds(2);
		    LOGGER.info("Terminado future1b for runAfterBoth!");
		}, executor);
		 
		CompletableFuture<Void> future2b = CompletableFuture.runAsync(() -> {
		    LOGGER.info("Comenzando future2b for runAfterBoth...");
		    Sleep.sleepSeconds(1);
		    LOGGER.info("Terminado future2b for runAfterBoth!");
		}, executor);
		 
		future1b.runAfterBothAsync(future2b, () -> LOGGER.info("En el runAfterBoth, futuros terminados.")
		        , executor);
	}
	
	@Ignore
	public void testRunFutureExceptions() throws Exception{
		// runAfterBoth
		CompletableFuture<Void> future1b = CompletableFuture.runAsync(() -> {
		    LOGGER.info("Comenzando future1b for runAfterBoth...");
		    Sleep.sleepSeconds(2);
//		    int resultado = 1 / 0;
		    LOGGER.info("Terminado future1b for runAfterBoth!");	    
		}, executor);
		
		future1b.whenCompleteAsync((s, e) -> {
			LOGGER.error("Error ", e);
		}, executor);
		
		CompletableFuture<Void> future2b = CompletableFuture.runAsync(() -> {
		    LOGGER.info("Comenzando future2b for runAfterBoth...");
		    Sleep.sleepSeconds(1);
		    LOGGER.info("Terminado future2b for runAfterBoth!");
		}, executor);
		 
		CompletableFuture<Void> futuro = future1b.runAfterBothAsync(future2b, () -> LOGGER.info("En el runAfterBoth, futuros terminados.")
		        , executor);
		
		futuro.whenCompleteAsync((s, e) -> {
			if(e != null) LOGGER.error("ERROR en futuro: ", e);
			else System.out.println(s);
		}, executor);
	}
	
	@Test
	public void TestAllOfCompletableFuture(){
		// allOf
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
		    LOGGER.info("Comenzando future1 for allOf...");
		    Sleep.sleepSeconds(2);
		    LOGGER.info("Terminado future1 for allOf!");
		    return "Terminado future1";
		}, executor);
		 
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
		    LOGGER.info("Comenzando future2 for allOf...");
		    Sleep.sleepSeconds(1);
		    LOGGER.info("Terminado future2 for allOf!");
		    return "Terminado future2";
		}, executor);
		 
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
		    LOGGER.info("Comenzando future3 for allOf...");
		    Sleep.sleepSeconds(3);
		    LOGGER.info("Terminado future3 for allOf!");
		    return "Terminado future3";
		}, executor);
		 
		CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3);
		 
		all.whenCompleteAsync((s, e) ->{
			//s -- Será null allOf no retorna valor.
			LOGGER.info("Resultado all: {}", s);
		}, executor);	
	}
}







