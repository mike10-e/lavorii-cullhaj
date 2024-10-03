package ProduttoreConsumatore;
import java.util.Random;

public class Consumatore implements Runnable {
	private int pari;
	private int dispari;
	Buffer buffer;
	Random random = new Random();
	
	public Consumatore(Buffer buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
		pari = 0;
		dispari = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int num = buffer.togli();
			System.out.println("Elemento rimosso: " + num);
			    
			if (num%2 == 0) {
				pari++;
			} else {
				dispari++;
			}
			System.out.println("I numeri pari sono: " + pari);
			System.out.println("I numeri dispari sono:" + dispari);

			int x = random.nextInt(1000)+100;
			try {
				Thread.sleep(x);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
