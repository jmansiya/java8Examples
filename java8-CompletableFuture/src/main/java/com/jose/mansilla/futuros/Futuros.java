package com.jose.mansilla.futuros;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jose.mansilla.Sleep;

public class Futuros {
	private final static Logger LOGGER = LoggerFactory.getLogger(Futuros.class);
	
	public CompletableFuture<String> getFuturo1(String entrada){
		//En este caso en vez de una cadena de futuros, esperaremos a que terminen dos futuros, par aluego hacer
		//algo con ellos.
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Comenzamos el primer futuro!." );
			Sleep.sleepSeconds(1);
			LOGGER.info("Terminamos el primer futuro!.");
			return entrada;
		});
		
		return future1;
	}
	
	public CompletableFuture<String> getFuturo2(String entrada){
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			LOGGER.info("Comenzamos el segundo futuro!.");
			Sleep.sleepSeconds(1);
			LOGGER.info("Terminamos el segundo futuro!.");
			return entrada;
		});
		
		return future2;
	}
	
	public CompletableFuture<String> combineFutures(CompletableFuture<String> futuro1, CompletableFuture<String> futuro2){
		CompletableFuture<String> combineFutures =
				futuro1.thenCombineAsync(futuro2, (s1, s2) -> {
					LOGGER.info("En el theCombine, recibidos resultados {} {} ", s1, s2);
					
					return s1 + s2;
				});
		
		return combineFutures;
	}
	
	public void combinacionFuturos(String cadena1, String cadena2) throws Exception{
		CompletableFuture<String> fut1 = this.getFuturo1(cadena1);
		CompletableFuture<String> fut2 = this.getFuturo2(cadena2);
		
		CompletableFuture<String> combineFutures = this.combineFutures(fut1, fut2);
		
		combineFutures.whenCompleteAsync((s, e) -> {
			LOGGER.info("Resultado de la combinación: " + s);
		});
		
	}
}
