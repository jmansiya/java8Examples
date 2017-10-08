package com.josemansilla.java8;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Utilización de funciones javascript desde java.
 * 
 * Invocación de codigo JS desde JAVA.  
 * 
 *  **** nashorn ***
 *  Abrir terminal y ejecutar jjs -v comprobaremos que tenemos instalado jjs.
 * 
 * @author josemansilla
 *
 */
public class NashApp{
	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;
	
	public NashApp(){
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador = (Invocable) e;
	}
	
	public void llamarFunciones() throws Exception{
		//e.eval("print('JS desde Java')");
		
		e.eval(new FileReader("src/main/java/com/josemansilla/java8/java.js"));
		double respuesta = (double) invocador.invokeFunction("calcular", 2, 3);
		
		System.out.println(respuesta);
	}
	
	public void implementarInterfaz() throws Exception{
		e.eval(new FileReader("src/main/java/com/josemansilla/java8/java.js"));
	
		Object implementacion = e.get("hiloImpl");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		
		Thread th1 = new Thread(r);
		th1.start();
		Thread th2 = new Thread(r);
		th2.start();
		
	}
	
	public static void main(String[] args) throws Exception {
		NashApp app = new NashApp();
		
		app.llamarFunciones();
		
		app.implementarInterfaz();
		
	}

}




