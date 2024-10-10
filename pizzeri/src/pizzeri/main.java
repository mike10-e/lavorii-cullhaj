package pizzeri;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Buffer BufferOrdini1 = new Buffer();
		Buffer BufferOrdini2 = new Buffer();
		Buffer BufferPizza1 = new Buffer();
		Buffer BufferPizza2 = new Buffer();
		
		Pizzaiolo pizzaiolo = new Pizzaiolo(BufferOrdini2,BufferPizza2);
		Thread ThreadForno  = new Thread(pizzaiolo);
		ThreadForno.start();
		
		Cameriere cameriere1 = new Cameriere(BufferOrdini1, BufferPizza1, BufferOrdini2,BufferPizza2);
		Cameriere cameriere2 = new Cameriere(BufferOrdini1, BufferPizza1, BufferOrdini2,BufferPizza2);
		Cameriere cameriere3 = new Cameriere(BufferOrdini1, BufferPizza1, BufferOrdini2,BufferPizza2);
		
		Thread ThreadC1 = new Thread(cameriere1);
		Thread ThreadC2 = new Thread(cameriere2);
		Thread ThreadC3 = new Thread(cameriere3);
		
		ThreadC1.start();
		ThreadC2.start();
		ThreadC3.start();
		
		int x = random.nextInt(20)+1;
		System.out.println("Sono stai occupati " + x + " tavoli" );
		Tavolo[] tavoli = new Tavolo[x];
		
	    for (int i = 0; i < tavoli.length; i++) {
            tavoli[i] = new Tavolo(BufferOrdini1,BufferPizza1, i+1);
        }
	    
	    for (int i = 0; i < tavoli.length; i++) {
            Thread thread = new Thread(tavoli[i]);
            thread.start();
	    }
		
	   
	}

}
	