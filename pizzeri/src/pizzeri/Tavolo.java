package pizzeri;

import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Tavolo implements Runnable {

	private int numTavolo;
	private int persone;
	private int pizzaOrdinate;
	Buffer Ordina1;
	Buffer bufferPizza1;
	private List<Integer> pizzeOrdinate;
	Random random= new Random();
	
	public Tavolo(Buffer Buffer,Buffer bufferPizza,int n) {
		Ordina1 = Buffer;
		this.bufferPizza1 = bufferPizza;
		numTavolo = n;
		persone = random.nextInt(5)+1;
		pizzaOrdinate = 0;
		this.pizzeOrdinate = new ArrayList<>();
	}
	
	
	public int getPizzaOrdinate() {
		return pizzaOrdinate;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		GeneraOrdini();
		ConsumaPizze();
	}
	
	private void GeneraOrdini() {
		int pizza;
		System.out.println("Tavolo " + numTavolo + ": "+ "ha ordinato: " + persone);
		for (int i = 0; i < persone; i++) {
			pizza = random.nextInt(5)+1;
			Ordina1.inserisci(pizza);
			pizzeOrdinate.add(pizza);
			pizzaOrdinate++;
			int x = random.nextInt(5000)+100;
			try {
				Thread.sleep(x);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
		}
	}
		
	
	private void ConsumaPizze() {
		while (!pizzeOrdinate.isEmpty()) { // Continua a consumare finché ci sono pizze da consumare
            int pizza = bufferPizza1.togli(); // Togli una pizza dal buffer delle pizze pronte
			
			// Verifica se la pizza è stata ordinata da questo tavolo
			if (pizzeOrdinate.contains(pizza)) {
			    pizzeOrdinate.remove(Integer.valueOf(pizza)); // Rimuove la pizza dalla lista
			   // System.out.println("Tavolo " + numTavolo + ": ha consumato una pizza di tipo " + pizza);
			} else {
			    // Se la pizza non è per questo tavolo, la riaggiungiamo nel buffer
			    bufferPizza1.inserisci(pizza); // Riaggiungi la pizza al buffer
			}
        }
        System.out.println("Tavolo " + numTavolo + ": ha consumato tutte le pizze ordinate.");
	}
}