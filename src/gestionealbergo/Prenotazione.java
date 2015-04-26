package gestionealbergo;

import java.time.*;

public class Prenotazione {
	
	private LocalDateTime dal;
	private LocalDateTime al;
	private Cliente cliente;
	private Camera camera;
	
	public Prenotazione(LocalDateTime dal, LocalDateTime al, Cliente cliente) {
		if(dal != null && al != null){
			if(dal.isBefore(al)){
				this.dal = dal;
				this.al = al;
			}
			else{
				throw new IllegalArgumentException("la partenza deve avvenire dopo l'arrivo");
			}
		}
		else{
			throw new IllegalArgumentException("al e dal non possono essere null");
		}
		if(cliente != null){
		   this.cliente = cliente;
		}
		else{
			throw new IllegalArgumentException("cliente non può essere null");
		}
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		if(camera != null){
		   this.camera = camera;
		}
		else{
			throw new IllegalArgumentException("camera non può essere null");
		}
	}

	public LocalDateTime getDal() {
		return dal;
	}

	public LocalDateTime getAl() {
		return al;
	}

	public Cliente getCliente() {
		return cliente;
	}

	
	
	@Override
	public String toString() {
		return "Prenotazione [dal=" + dal + ", al=" + al + ", cliente="
				+ cliente + ", camera=" + camera + "]";
	}

	public int getNumeroNotti(){
		
		
		return Period.between(dal.toLocalDate(), al.toLocalDate()).getDays();
		
	}
	
	
	
}