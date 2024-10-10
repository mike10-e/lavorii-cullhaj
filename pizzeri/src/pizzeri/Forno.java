package pizzeri;

public class Forno {
	  private int[] buffer;
	    private int testa;
	    private int coda;
	    private int count;
	    private int capacitaMax;

	    public Forno() {
	        capacitaMax = 8;
	        buffer = new int[capacitaMax];
	        testa = 0;
	        coda = 0;
	        count = 0;
	    }

	    // Aggiungi una pizza (numero intero) al buffer
	    public synchronized void aggiungiPizza(int pizza) {
	        while (count == capacitaMax) {  // Se il buffer è pieno
	            try {
	                System.out.println("Forno pieno. Attendere...");
	                wait();  // Attende finché non c'è spazio
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        buffer[coda] = pizza;  // Inserisci la pizza alla posizione 'tail'
	        coda = (coda + 1) % capacitaMax;  // Ciclo circolare
	        count++;
	        System.out.println("Pizza " + pizza + " aggiunta in forno. Pizze in cottura: " + count);
	        notifyAll();  // Notifica gli altri thread
	    }

	    // Rimuovi una pizza dal buffer
	    public synchronized int togliPizza() {
	        while (count == 0) {  // Se il buffer è vuoto
	            try {
	                System.out.println("Nessuna pizza pronta. Pizzaiolo in attesa...");
	                wait();  // Attende finché non ci sono pizze pronte
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        int pizzaPronta = buffer[testa];  // Estrai la pizza dalla posizione 'head'
	        testa = (testa + 1) % capacitaMax;  // Ciclo circolare
	        count--;
	        System.out.println("Pizza " + pizzaPronta + " tolta dal forno. Pizze rimanenti: " + count);
	        notifyAll();  // Notifica gli altri thread
	        return pizzaPronta;
	    }

	    // Controlla se ci sono pizze pronte
	    public synchronized boolean ciSonoPizzePronte() {
	        return count > 0;
	    }

	    // Ritorna il numero di pizze attualmente in forno
	    public synchronized int pizzeInForno() {
	        return count ;
	    }
}
