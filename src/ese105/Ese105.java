package ese105;

import java.time.LocalDateTime;

import gestionealbergo.*;

public class Ese105 {

	public static void main(String[] args) throws Exception {
		Albergo overlook = new Albergo("Overlook Hotel");
		
		Tripla Grande = new Tripla("300",3);
		Doppia Media = new Doppia("200",2);
		Singola Piccola = new Singola("100",1);
		
		overlook.getCamere().add(Grande);
		overlook.getCamere().add(Media);
		overlook.getCamere().add(Piccola);
		
		Cliente barack = new Cliente("Barack", "Obama", "+01 123456789");
		Cliente ugo = new Cliente("Ugo", "Fantozzi", "+39 123456789", "ugo@fantozzi.com");
		Cliente rita = new Cliente("Rita", "Coccia", "+39 987654321", "dirigente@avolta.pg.it");
		
		Prenotazione p = null;
		
		// ------------------------------------------------------
		
		System.out.print("Test 01...");
		try {
			p = new Prenotazione(
					LocalDateTime.of(2015, 04, 23, 00, 00, 00),
					LocalDateTime.of(2015, 04, 22, 00, 00, 00),
					barack);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if (e.getMessage().equals("Eccezione non lanciata"))
				System.out.println("ERROR");
			else
				System.out.println("OK");
		}
		
		// ------------------------------------------------------
		
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 23, 00, 00, 00),
				LocalDateTime.of(2015, 04, 25, 00, 00, 00),
				barack);
		System.out.print("Test 02...");
		if(p.getNumeroNotti() == 2)
			System.out.println("OK");
		else
			throw new Exception("Numero notti non conforme");
		
		Grande.addPrenotazione(p);
		
		System.out.print("Test 02a..");
		if (p.getCamera() == Grande)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// ------------------------------------------------------
		
		System.out.print("Test 03...");
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 23, 00, 00, 00),
				LocalDateTime.of(2015, 04, 25, 00, 00, 00),
				rita);
		try {
			Grande.addPrenotazione(p);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if (e.getMessage().equals("Eccezione non lanciata"))
				System.out.println("ERROR");
			else
				System.out.println("OK");
		}
		
		System.out.print("Test 03a..");
		if (p.getCamera() == null)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// ------------------------------------------------------
		
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 25, 15, 00, 00),
				LocalDateTime.of(2015, 04, 27, 11, 00, 00),
				rita);
		
		System.out.print("Test 04...");
		if (p.getCamera() == null)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		System.out.print("Test 04a..");
		Grande.addPrenotazione(p);
		System.out.println("OK");
		
		System.out.print("Test 04b..");
		if (p.getCamera() == Grande)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		

		// ------------------------------------------------------
		
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 14, 15, 00, 00),
				LocalDateTime.of(2015, 04, 20, 11, 00, 00),
				ugo);
		
		System.out.print("Test 05...");
		if (p.getCamera() == null)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		System.out.print("Test 05a..");
		Piccola.addPrenotazione(p);
		System.out.println("OK");
		
		System.out.print("Test 05b..");
		if (p.getCamera() == Piccola)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// ------------------------------------------------------
		
		System.out.print("Test 06...");
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 13, 00, 00, 00),
				LocalDateTime.of(2015, 04, 17, 00, 00, 00),
				rita);
		try {
			Piccola.addPrenotazione(p);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if (e.getMessage().equals("Eccezione non lanciata"))
				System.out.println("ERROR");
			else
				System.out.println("OK");
		}
		
		System.out.print("Test 06a..");
		if (p.getCamera() == null)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// ------------------------------------------------------
		System.out.println("\n==> Elenco camere");
		for(Camera c : overlook.getCamere()) {
			System.out.println(c.toString());
		}
		
		System.out.println("\n==> Elenco prenotazioni");
		for(Camera c : overlook.getCamere()) {
			for(Prenotazione q : c.getPrenotazioni()) {
				System.out.println(q.toString());
			}
		}
		
	}

}