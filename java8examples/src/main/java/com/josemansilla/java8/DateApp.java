package com.josemansilla.java8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateApp{
	public void verificar(int version){
		if (version == 7){
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			fecha1.set(1991, 0, 21);
			
			System.out.println(fecha1.after(fecha2));
		} else if (version == 8){
			//Versión java 8.
			LocalDate fecha1 = LocalDate.of(1991, 1, 21);
			LocalDate fecha2 = LocalDate.now();
			
			System.out.println(fecha1.isAfter(fecha2));
			
			//Horas.
			LocalTime tiempo1 = LocalTime.of(22,  30, 50);
			LocalTime tiempo2 = LocalTime.now();
			
			System.out.println("Tiempo: " + tiempo1.isAfter(tiempo2));
			
			LocalDateTime tiempoCompleto1 = LocalDateTime.of(fecha1, tiempo1);
			LocalDateTime tiempoCompletoAhora = LocalDateTime.now();
			
			System.out.println("Tiempo completo: " + tiempoCompleto1.isAfter(tiempoCompletoAhora));
		}
	}
	
	public void medirTiempo(int version) throws InterruptedException{
		if (version == 7){
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			
			System.out.println(fin - ini);
		} else if (version == 8){
			Instant ini = Instant.now();
			Thread.sleep(1000);
			
			Instant fin = Instant.now();
			
			System.out.println("milisegundos: " + Duration.between(ini, fin).toMillis());
			System.out.println("Minutos: " + Duration.between(ini, fin).toMinutes());
			System.out.println("Segundos: " + Duration.between(ini, fin).getSeconds());
			System.out.println("String: " + Duration.between(ini, fin).toString());
			System.out.println("Dias: " + Duration.between(ini, fin).toDays());
		}
	}
	
	public void periodoEntreFechas(int version){
		if (version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			
			nacimiento.set(1981,  1, 15);
			actual.set(2017, 9, 9);
			
			int anios = 0;
			
			while(nacimiento.before(actual)){
				nacimiento.add(Calendar.YEAR, 1);
				
				if(nacimiento.before(actual)){
					anios++;
				}
			}
			
			System.out.println("Edad : " + anios + " Años.");
		} else if (version == 8){
			LocalDate nacimiento = LocalDate.of(1981, 2, 15);
			LocalDate actual = LocalDate.now();
			
			Period periodo = Period.between(nacimiento, actual);
			
			System.out.println("Han transcurrido " + periodo.getYears() + ",  " + periodo.getMonths() + "meses y " + periodo.getDays() + " dias"
					+ " desde " + nacimiento + " hasta " + actual);
		
			Locale locale = new Locale("es", "ES");
			System.out.println(nacimiento.getMonth().getDisplayName(TextStyle.FULL, locale));
			//LocalDate puede devolver con nacimiento.getMonth()....
		}
	}
	
	public void convertir(int version) throws ParseException{
		if(version == 7){
			String fecha = "15/01/1991";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena  = formateador.format(fechaActual);
			
			System.out.println(fechaCadena);
		} else if (version == 8){
			String fecha = "15/02/1981";
			DateTimeFormatter formateador8 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador8);
			
			System.out.println(fechaLocal);
			
			formateador8 = DateTimeFormatter.ofPattern("ddMMyyyy");
			System.out.println(formateador8.format(fechaLocal));
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		DateApp app = new DateApp();
		
		app.verificar(8);
		
		//app.medirTiempo(8);
		
		app.periodoEntreFechas(8);
		
		try {
			app.convertir(8);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}




