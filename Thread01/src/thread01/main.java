package thread01;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci il numero di Thread (t):");
		int t = scanner.nextInt();
		
		System.out.println("Inserisci  fino a quale numero deve contare (n):");
		int n = scanner.nextInt();
		 Random random = new Random();
		
		Thread[] thread = new Thread[t];
		lavoratore[] l = new lavoratore[t];
		for (int i = 0; i < t; i++) {
			int X = random.nextInt(n + 1);
			l[i] = new lavoratore(n,X);
			thread[i] = new Thread(l[i]);
			thread[i].start();	
			System.out.println("Thread " + i + " lavora fino a " + X);
		}
		
		boolean check  = true;
		int finito = 0;
		while(check) {
			for (int i = 0; i < t; i++) {

				if(l[i].isComplete()) {
					finito++;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				if (finito == t) {
					check = false;
				}
			}

			
	}
	System.out.println("TUTTI I THREAD COMPLETATI");
	}
}
