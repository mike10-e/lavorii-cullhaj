package pizzeri;

import java.util.Random;

public class Pizzaiolo implements Runnable {
	Buffer BufferOrdini2;
	Buffer BufferPizza2;
	private int pizzePronte;
	Random random = new Random();
	Forno forno = new Forno();
	
	
	public Pizzaiolo(Buffer bufferOrdini2,Buffer bufferPizza2) {
		// TODO Auto-generated constructor stub
		this.BufferOrdini2 = bufferOrdini2;
		this.BufferPizza2 = bufferPizza2;
		pizzePronte = 0;
	}

	public int getPizzePronte() {
		return pizzePronte;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int ordine;
		do{
			   ordine = BufferOrdini2.togli();
			   cuociPizza(ordine);
			   BufferPizza2.inserisci(ordine);
			   pizzePronte++;
			   System.out.println(pizzePronte);
		}while(true);
		
	}
	
	
	private void cuociPizza(int pizza) {
        int tempoCottura = random.nextInt(5000) + 1000;  // Simula il tempo di cottura
        try {
          //  System.out.println("Pizza " + pizza + " in cottura...");
            Thread.sleep(tempoCottura);  // Simula il tempo di cottura
            //System.out.println("Pizza " + pizza + " pronta!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
