package ProduttoreConsumatore;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Buffer buffer = new Buffer();
		
		//creo il thread produttore
		Produttore p = new Produttore(buffer);
		Thread produttore = new Thread(p);
		
		//creo il thread consumatore
		Consumatore c = new Consumatore(buffer);
		Thread consumatore = new Thread(c);
		
		produttore.start();
		consumatore.start();
		
	}

}
