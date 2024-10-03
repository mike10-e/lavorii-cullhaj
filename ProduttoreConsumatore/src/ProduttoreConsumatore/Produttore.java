package ProduttoreConsumatore;
import java.util.Random;
public class Produttore implements Runnable {
	Random random = new Random();
	Buffer buffer;
	
	public Produttore(Buffer buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int num = random.nextInt(1023);
			buffer.inserisci(num);
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
