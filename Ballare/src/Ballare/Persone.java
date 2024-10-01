package Ballare;
import java.util.Random;

public class Persone implements Runnable {
	
	private int totPersone;
	Random random = new Random();
	@Override
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
		  totPersone++;
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
		totPersone--;
		  System.out.println(Thread.currentThread().getId() + " è usciti dalla discoteca.");

	}

	public int getTotPersone() {
		return totPersone;
	}
	
	

}
