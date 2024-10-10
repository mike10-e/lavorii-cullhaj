package pizzeri;

import java.util.Random;

public class Cameriere implements Runnable {
	Buffer bufferOrdini;
	Buffer bufferOrdini2;
	Buffer bufferPizza2;
	Buffer bufferPizza1;
	Random random = new Random();
	
	public Cameriere(Buffer bufferOrdini, Buffer bufferPizza, Buffer bufferOrdini2, Buffer bufferPizza2) {
			this.bufferOrdini = bufferOrdini;
			this.bufferOrdini2 = bufferOrdini2;
			this.bufferPizza2 = bufferPizza2;
			this.bufferPizza1 = bufferPizza;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ordine;
		int pizza;
		while(true) {
			ordine = PrendiOrdine();
			//System.out.println("l'ordine: " + ordine + " è stato preso");
			ConsegnaOrdine(ordine);
			//System.out.println("l'ordine: " + ordine + " è stato consegnato");
			pizza = PrendiPizza();
			ConsegnaPizza(pizza);
		}
	}
	
	private int PrendiOrdine() {
		
		int x = random.nextInt(5000)+100;
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ordine = bufferOrdini.togli();
		return ordine;
	}
	
	private void ConsegnaOrdine(int n) {
		
		int x = random.nextInt(5000)+100;
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferOrdini2.inserisci(n);
	}
	
	private int PrendiPizza() {
		int pizza;
		int x = random.nextInt(5000)+100;
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pizza = bufferPizza2.togli();
		return pizza;
	}
	
	private void ConsegnaPizza(int n) {
		int x = random.nextInt(5000)+100;
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferPizza1.inserisci(n);
	}
}
