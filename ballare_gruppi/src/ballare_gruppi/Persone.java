package ballare_gruppi;

import java.util.Random;

public class Persone implements Runnable {
	private discoteca disco;
	private int numGruppo;
	private int totPersone;
	Random random = new Random();

	public Persone(discoteca discoteca,int numGruppo) {
		disco = discoteca;
		this.numGruppo = numGruppo;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			EntraDiscoteca();
			RestaDiscoteca();
			EsciDiscoteca();
			RestaDiscoteca();
		}
	}
	
	private void EntraDiscoteca() {
		  disco.entra(numGruppo);
		  System.out.println(Thread.currentThread().getId() + " è entrato nella discoteca.");
	}
	
	private void RestaDiscoteca() {
		
		int X = random.nextInt(4000) + 1000;
		try {
			Thread.sleep(X);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void EsciDiscoteca() {
		disco.esci(numGruppo);
		  System.out.println(Thread.currentThread().getId() + " è usciti dalla discoteca.");

	}

	public int getTotPersone() {
		return totPersone;
	}
	

}
