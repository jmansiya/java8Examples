package com.jose.mansilla.test;

import static org.junit.Assert.fail;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
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
	
	@Test
	public void testFutureCreationNew(){
		CompletableFuture<String> future = new CompletableFuture<String>();
		LOGGER.info("Completable Creado...");
		
		future.whenCompleteAsync((s, e) -> LOGGER.info("Resultado: " + s), executor);
		
		LOGGER.info("Registrado el when complete async");
		Sleep.sleepSeconds(2);
		future.complete("Completado");
	}
	
	@Test
    public void testFutureCreationRunAsync() {
        CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> {
            LOGGER.info("Comenzando runAsync...");
            Sleep.sleepSeconds(3);
            LOGGER.info("Terminado runAsync!");
        }, executor);

        futureAsync.whenCompleteAsync((s, e) -> LOGGER.info("Sin resultado..."), executor);
        LOGGER.info("Terminado main thread");
    }
	
    @Test
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

    @Test
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
}
