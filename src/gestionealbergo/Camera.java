package gestionealbergo;

import java.time.LocalDateTime;
import java.util.Vector;


public abstract class Camera {
	
	private String numero;
	private int numeroLetti;
	private Vector<Prenotazione> prenotazioni;
	
	public Camera(String numero, int numeroLetti) {
		if(numero != null){
				this.numero = numero;
		}
		else{
			throw new IllegalArgumentException("numero non può essere null");
		}
		if(numeroLetti>0 && numeroLetti<4){
			this.numeroLetti=numeroLetti;
		}
		else{
			throw new IllegalArgumentException("il numero dei letti può andare solo da uno a tre");
		}
		this.prenotazioni = new Vector<Prenotazione>();
	}
	public String getNumero() {
		return numero;
	}
	
	public Vector<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	
	
	
	public int getNumeroLetti() {
		return numeroLetti;
	}
	
	@Override
	public String toString() {
		return "Camera [numero=" + numero + ", numeroLetti=" + numeroLetti
				+ ", prenotazioni=" + prenotazioni.size() + "]";
	}
	public void addPrenotazione(Prenotazione p){
		
		if(p != null){
			
			if(this.isDisponibile(p.getDal(), p.getAl())){
				
				p.setCamera(this); 
				this.prenotazioni.add(p); 

			
			}
			else{
				throw new IllegalArgumentException("la camera non è disponibile");
			}
		
		}
		else{
			throw new IllegalArgumentException("p non può essere null");
		}
	}
	
	
	public boolean isDisponibile(LocalDateTime dal, LocalDateTime al){
		
		boolean disponibile = true;
		for(Prenotazione p : prenotazioni){
			
			if(!dal.isAfter(p.getAl()) && !al.isBefore(p.getDal())){
				
			disponibile = false;
			}
		
		
	    }
		
		return disponibile;
	
	}
}