package ballare_gruppi;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		discoteca disco = new discoteca();
		
		for (int i = 0; i < 20; i++) {
            int N = random.nextInt(20) + 1; // Genera un numero casuale tra 1 e 20
            Persone persona = new Persone(disco,N); // Crea una nuova istanza di Persone con N
            Thread thread = new Thread(persona); 
            thread.start(); 
        }
		
		while(true) {
			try {
				Thread.sleep(1000);
			System.out.println(disco.getTotPersone());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
